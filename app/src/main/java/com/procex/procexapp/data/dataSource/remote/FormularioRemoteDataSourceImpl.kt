package com.procex.procexapp.data.dataSource.remote

import com.procex.procexapp.data.dataSource.remote.service.FormularioService
import com.procex.procexapp.domain.model.Formulario
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class FormularioRemoteDataSourceImpl(private val formularioService: FormularioService):
    FormularioRemoteDataSource {

    var cantidadRegistros: Int = 0

    override suspend fun create(formulario: Formulario, file: File): Response<Formulario>{
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // tipo del archivo de imagen
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val consultaData = formulario.consulta.toRequestBody(contentType.toMediaTypeOrNull())
        val name_medData = formulario.name_med.toRequestBody(contentType.toMediaTypeOrNull())
        val nameData = formulario.name.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_documentoData = formulario.tipo_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val num_documentoData = formulario.num_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val sexoData = formulario.sexo.toRequestBody(contentType.toMediaTypeOrNull())
        val fechaData = formulario.fecha.toRequestBody(contentType.toMediaTypeOrNull())
        val telefonoData = formulario.telefono.toRequestBody(contentType.toMediaTypeOrNull())
        val antecedentes_medicosData = formulario.antecedentes_medicos.toRequestBody(contentType.toMediaTypeOrNull())
        val RHData = formulario.RH.toRequestBody(contentType.toMediaTypeOrNull())
        val historial_familiarData = formulario.historial_familiar.toRequestBody(contentType.toMediaTypeOrNull())
        val medicamentos_acData = formulario.medicamentos_ac.toRequestBody(contentType.toMediaTypeOrNull())
        val historial_vacunasData = formulario.historial_vacunas.toRequestBody(contentType.toMediaTypeOrNull())
        val nota_unoData = formulario.nota_uno.toRequestBody(contentType.toMediaTypeOrNull())
        val nota_dosData = formulario.nota_dos?.toRequestBody(contentType.toMediaTypeOrNull())
        val seguroData = formulario.seguro.toRequestBody(contentType.toMediaTypeOrNull())

        return formularioService.create(fileFormData, consultaData, name_medData, nameData, tipo_documentoData, num_documentoData, sexoData, fechaData,
            telefonoData, antecedentes_medicosData, RHData, historial_familiarData, medicamentos_acData, historial_vacunasData,
            nota_unoData, nota_dosData, seguroData)
    }

    override suspend fun getFormulario(): Response<List<Formulario>> {
        val response = formularioService.getFormulario()
        if (response.isSuccessful) {
            cantidadRegistros = response.body()?.size ?: 0
        }
        return response
    }


    override suspend fun findByNum(num_documento: String): Response<List<Formulario>> = formularioService.findByNum(num_documento)

    override suspend fun findByType(tipo_documento: String): Response<List<Formulario>> = formularioService.findByType(tipo_documento)

    override suspend fun findByTypeAndNum(tipo_documento: String, num_documento: String): Response<List<Formulario>> = formularioService.findByTypeAndNum(tipo_documento, num_documento)

    override suspend fun update(id: String, formulario: Formulario): Response<Formulario> = formularioService.update(id, formulario)


    override suspend fun updateWithImage(
        id: String,
        formulario: Formulario,
        file: File
    ): Response<Formulario> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // tipo del archivo de imagen
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val consultaData = formulario.consulta.toRequestBody(contentType.toMediaTypeOrNull())
        val name_medData = formulario.name_med.toRequestBody(contentType.toMediaTypeOrNull())
        val nameData = formulario.name.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_documentoData = formulario.tipo_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val num_documentoData = formulario.num_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val sexoData = formulario.sexo.toRequestBody(contentType.toMediaTypeOrNull())
        val fechaData = formulario.fecha.toRequestBody(contentType.toMediaTypeOrNull())
        val telefonoData = formulario.telefono.toRequestBody(contentType.toMediaTypeOrNull())
        val antecedentes_medicosData = formulario.antecedentes_medicos.toRequestBody(contentType.toMediaTypeOrNull())
        val RHData = formulario.RH.toRequestBody(contentType.toMediaTypeOrNull())
        val historial_familiarData = formulario.historial_familiar.toRequestBody(contentType.toMediaTypeOrNull())
        val medicamentos_acData = formulario.medicamentos_ac.toRequestBody(contentType.toMediaTypeOrNull())
        val historial_vacunasData = formulario.historial_vacunas.toRequestBody(contentType.toMediaTypeOrNull())
        val nota_unoData = formulario.nota_uno.toRequestBody(contentType.toMediaTypeOrNull())
        val nota_dosData = formulario.nota_dos?.toRequestBody(contentType.toMediaTypeOrNull())
        val seguroData = formulario.seguro.toRequestBody(contentType.toMediaTypeOrNull())

        return formularioService.updateWithImage(fileFormData, id, consultaData, name_medData, nameData, tipo_documentoData, num_documentoData, sexoData, fechaData, telefonoData, antecedentes_medicosData,
        RHData, historial_familiarData, medicamentos_acData, historial_vacunasData, nota_unoData, nota_dosData, seguroData)
    }

    override suspend fun delete(id: String): Response<Unit> = formularioService.delete(id)


}
