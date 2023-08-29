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

    override fun findBySexoF(sexo: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findBySexoF(sexo)))
    }

    override fun findBySexoM(sexo: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findBySexoM(sexo)))
    }

    override fun findByMes1(created_at: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByMes1(created_at)))
    }

    override fun findByMes2(created_at: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByMes2(created_at)))
    }

    override fun findVisitasEfectivas(cl_visitas: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findVisitasEfectivas(cl_visitas)))
    }

    override fun findVisitasNoEfectivas(cl_visitas: String): Flow<Resource<List<Formulario>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findVisitasNoEfectivas(cl_visitas)))
    }


    override suspend fun update(id: String, formulario: Formulario): Resource<Formulario> {
        ResponseToRequest.send(remoteDataSource.update(id, formulario)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name_med = this.data.name_med,
                        name = this.data.name,
                        tipo_documento = this.data.tipo_documento,
                        num_documento = this.data.num_documento,
                        sexo = this.data.sexo,
                        RH = this.data.RH,
                        fecha = this.data.fecha,
                        telefono = this.data.telefono,
                        tipo_visita = this.data.tipo_visita,
                        cl_visita = this.data.cl_visita,
                        causa = this.data.causa,
                        direccion = this.data.direccion,
                        barrio = this.data.barrio,
                        propiedad = this.data.propiedad,
                        tensiona = this.data.tensiona,
                        tipo_ta = this.data.tipo_ta,
                        toma_ta = this.data.toma_ta,
                        resultado_ta = this.data.resultado_ta,
                        oximetria = this.data.oximetria,
                        toma_oxi = this.data.toma_oxi,
                        resultado_oxi = this.data.resultado_oxi,
                        findrisk = this.data.findrisk,
                        estatura = this.data.estatura,
                        peso = this.data.peso,
                        nota_uno = this.data.nota_uno,
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
                        name_med = this.data.name_med,
                        name = this.data.name,
                        tipo_documento = this.data.tipo_documento,
                        num_documento = this.data.num_documento,
                        sexo = this.data.sexo,
                        RH = this.data.RH,
                        fecha = this.data.fecha,
                        telefono = this.data.telefono,
                        tipo_visita = this.data.tipo_visita,
                        cl_visita = this.data.cl_visita,
                        causa = this.data.causa,
                        direccion = this.data.direccion,
                        barrio = this.data.barrio,
                        propiedad = this.data.propiedad,
                        tensiona = this.data.tensiona,
                        tipo_ta = this.data.tipo_ta,
                        toma_ta = this.data.toma_ta,
                        resultado_ta = this.data.resultado_ta,
                        oximetria = this.data.oximetria,
                        toma_oxi = this.data.toma_oxi,
                        resultado_oxi = this.data.resultado_oxi,
                        findrisk = this.data.findrisk,
                        estatura = this.data.estatura,
                        peso = this.data.peso,
                        nota_uno = this.data.nota_uno,
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

