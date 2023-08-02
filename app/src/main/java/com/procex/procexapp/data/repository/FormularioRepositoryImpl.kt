package com.procex.procexapp.data.repository

import android.net.ConnectivityManager
import com.procex.procexapp.data.dataSource.local.FormularioLocalDataSource
import com.procex.procexapp.data.dataSource.remote.FormularioRemoteDataSource
import com.procex.procexapp.data.mapper.toFormulario
import com.procex.procexapp.data.mapper.toFormularioEntity
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.repository.FormularioRepository
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.domain.util.ResponseToRequest
import com.procex.procexapp.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File
import android.content.Context
import android.net.NetworkCapabilities
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.map
import java.io.IOException

class FormularioRepositoryImpl(
        private val remoteDataSource: FormularioRemoteDataSource,
        private val localDataSource: FormularioLocalDataSource,
        private val context: Context,

        ): FormularioRepository {

    override suspend fun create(formulario: Formulario, file: File): Resource<Formulario> {
        if (isInternetAvailable(context)) {
            try {
                val remoteResponse = ResponseToRequest.send(remoteDataSource.create(formulario, file))
                return when (remoteResponse) {
                    is Resource.Success -> {
                        val remoteFormulario = remoteResponse.data
                        val formularioId = remoteFormulario.id ?: ""

                        // Elimina los datos del formulario local si existen en la base de datos remota
                        if (isFormularioPresentRemotely(formularioId)) {
                            localDataSource.delete(formularioId)
                        }
                        Resource.Success(remoteFormulario)
                    }
                    else -> {
                        Resource.Failure("Error desconocido al enviar al origen de datos remoto")
                    }
                }
            } catch (e: Exception) {
                return Resource.Failure("Error al enviar al origen de datos remoto")
            }
        } else {
            // Guarda el formulario localmente si no hay conexión a Internet
            localDataSource.create(formulario.toFormularioEntity())
            return Resource.Success(formulario)
        }
    }

        private suspend fun isFormularioPresentRemotely(formularioId: String): Boolean {
        try {
            val remoteResponse = ResponseToRequest.send(remoteDataSource.getFormulario())
            return when (remoteResponse) {
                is Resource.Success -> {
                    val formularioRemoteList = remoteResponse.data
                    formularioRemoteList.any { formulario -> formulario.id == formularioId }
                }
                else -> false
            }
        } catch (e: Exception) {
            return false
        }
    }

    private fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

            return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }


    override fun getFormulario(): Flow<Resource<List<Formulario>>> = flow {

        localDataSource.getFormulario().collect() {
            it.run {
                val formularioLocalMap =
                    this.map { formularioEntity -> formularioEntity.toFormulario() }

                try {
                    ResponseToRequest.send(remoteDataSource.getFormulario()).run {
                        when (this) {
                            is Resource.Success -> {
                                val formularioRemote = this.data

                                if (!isListEqual(formularioRemote, formularioLocalMap)) {
                                    localDataSource.insertAll(formularioRemote.map { formulario -> formulario.toFormularioEntity() })
                                }

                                emit(Resource.Success(formularioLocalMap))

                            }

                            is Resource.Failure -> {
                                emit(Resource.Success(formularioLocalMap))
                            }

                            else -> {
                                emit(Resource.Success(formularioLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(formularioLocalMap))
                }

            }
        }
    }.flowOn(Dispatchers.IO)



    override fun findByNum(num_documento: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByNum(num_documento)))
    }

    override fun findByType(tipo_documento: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByType(tipo_documento)))
    }

    override fun findByTypeAndNum(tipo_documento: String, num_documento: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByTypeAndNum(tipo_documento, num_documento)))
    }


    override suspend fun update(id: String, formulario: Formulario): Resource<Formulario> {
        ResponseToRequest.send(remoteDataSource.update(id, formulario)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        consulta = this.data.consulta,
                        name_med = this.data.name_med,
                        name = this.data.name,
                        tipo_documento = this.data.tipo_documento,
                        num_documento = this.data.num_documento,
                        sexo = this.data.sexo,
                        fecha = this.data.fecha,
                        telefono = this.data.telefono,
                        antecedentes_medicos = this.data.antecedentes_medicos,
                        RH = this.data.RH,
                        historial_familiar = this.data.historial_familiar,
                        medicamentos_ac = this.data.medicamentos_ac,
                        historial_vacunas = this.data.historial_vacunas,
                        nota_uno = this.data.nota_uno,
                        nota_dos = this.data.nota_dos ?: "",
                        seguro = this.data.seguro,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun updateWithImage(
        id: String,
        formulario: Formulario,
        file: File
    ): Resource<Formulario> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, formulario, file)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        consulta = this.data.consulta,
                        name_med = this.data.name_med,
                        name = this.data.name,
                        tipo_documento = this.data.tipo_documento,
                        num_documento = this.data.num_documento,
                        sexo = this.data.sexo,
                        fecha = this.data.fecha,
                        telefono = this.data.telefono,
                        antecedentes_medicos = this.data.antecedentes_medicos,
                        RH = this.data.RH,
                        historial_familiar = this.data.historial_familiar,
                        medicamentos_ac = this.data.medicamentos_ac,
                        historial_vacunas = this.data.historial_vacunas,
                        nota_uno = this.data.nota_uno,
                        nota_dos = this.data.nota_dos ?: "",
                        seguro = this.data.seguro,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }

                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }


    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run{
            return when(this) {
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }

        }
    }


}

