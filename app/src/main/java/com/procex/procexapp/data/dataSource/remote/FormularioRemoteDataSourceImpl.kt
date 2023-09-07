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
        val estadoData = formulario.estado.toRequestBody(contentType.toMediaTypeOrNull())
        val name_medData = formulario.name_med.toRequestBody(contentType.toMediaTypeOrNull())
        val nameData = formulario.name.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_documentoData = formulario.tipo_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val num_documentoData = formulario.num_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val sexoData = formulario.sexo.toRequestBody(contentType.toMediaTypeOrNull())
        val RHData = formulario.RH.toRequestBody(contentType.toMediaTypeOrNull())
        val fechaData = formulario.fecha.toRequestBody(contentType.toMediaTypeOrNull())
        val telefonoData = formulario.telefono.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_visitaData = formulario.tipo_visita.toRequestBody(contentType.toMediaTypeOrNull())
        val cl_visitaData = formulario.cl_visita.toRequestBody(contentType.toMediaTypeOrNull())
        val causaData = formulario.causa.toRequestBody(contentType.toMediaTypeOrNull())
        val direccionData = formulario.direccion.toRequestBody(contentType.toMediaTypeOrNull())
        val barrioData = formulario.barrio.toRequestBody(contentType.toMediaTypeOrNull())
        val propiedadData = formulario.propiedad.toRequestBody(contentType.toMediaTypeOrNull())
        val tensionaData = formulario.tensiona.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_taData = formulario.tipo_ta.toRequestBody(contentType.toMediaTypeOrNull())
        val toma_taData = formulario.toma_ta.toRequestBody(contentType.toMediaTypeOrNull())
        val resultado_taData = formulario.resultado_ta.toRequestBody(contentType.toMediaTypeOrNull())
        val oximetriaData = formulario.oximetria.toRequestBody(contentType.toMediaTypeOrNull())
        val toma_oxiData = formulario.toma_oxi.toRequestBody(contentType.toMediaTypeOrNull())
        val resultado_oxiData = formulario.resultado_oxi.toRequestBody(contentType.toMediaTypeOrNull())
        val findriskData = formulario.findrisk.toRequestBody(contentType.toMediaTypeOrNull())
        val estaturaData = formulario.estatura.toRequestBody(contentType.toMediaTypeOrNull())
        val pesoData = formulario.peso.toRequestBody(contentType.toMediaTypeOrNull())
        val nota_unoData = formulario.nota_uno.toRequestBody(contentType.toMediaTypeOrNull())

        return formularioService.create(fileFormData, estadoData, name_medData, nameData, tipo_documentoData, num_documentoData, sexoData, RHData, fechaData,
            telefonoData, tipo_visitaData, cl_visitaData, causaData, direccionData, barrioData, propiedadData, tensionaData, tipo_taData, toma_taData, resultado_taData,
        oximetriaData, toma_oxiData, resultado_oxiData, findriskData, estaturaData, pesoData, nota_unoData)
    }

    override suspend fun getFormulario(): Response<List<Formulario>> {
        val response = formularioService.getFormulario()
        if (response.isSuccessful) {
            cantidadRegistros = response.body()?.size ?: 0
        }
        return response
    }

    override suspend fun findReady(estado: String): Response<List<Formulario>> = formularioService.findReady()

    override suspend fun findNotReady(estado: String): Response<List<Formulario>> = formularioService.findNotReady()

    override suspend fun findByNum(num_documento: String): Response<List<Formulario>> = formularioService.findByNum(num_documento)

    override suspend fun findByType(tipo_documento: String): Response<List<Formulario>> = formularioService.findByType(tipo_documento)

    override suspend fun findByTypeAndNum(tipo_documento: String, num_documento: String): Response<List<Formulario>> = formularioService.findByTypeAndNum(tipo_documento, num_documento)

    override suspend fun findBySexoF(sexo: String): Response<List<Formulario>> = formularioService.findBySexoF()

    override suspend fun findBySexoM(sexo: String): Response<List<Formulario>> = formularioService.findBySexoM()

    override suspend fun findByMes1(created_at: String): Response<List<Formulario>> = formularioService.findByMes1()

    override suspend fun findByMes2(created_at: String): Response<List<Formulario>> = formularioService.findByMes2()

    override suspend fun findVisitasEfectivas(cl_visita: String): Response<List<Formulario>> = formularioService.findVisitasEfectivas()

    override suspend fun findVisitasNoEfectivas(cl_visita: String): Response<List<Formulario>> = formularioService.findVisitasNoEfectivas()

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
        val estadoData = formulario.estado.toRequestBody(contentType.toMediaTypeOrNull())
        val name_medData = formulario.name_med.toRequestBody(contentType.toMediaTypeOrNull())
        val nameData = formulario.name.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_documentoData = formulario.tipo_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val num_documentoData = formulario.num_documento.toRequestBody(contentType.toMediaTypeOrNull())
        val sexoData = formulario.sexo.toRequestBody(contentType.toMediaTypeOrNull())
        val RHData = formulario.RH.toRequestBody(contentType.toMediaTypeOrNull())
        val fechaData = formulario.fecha.toRequestBody(contentType.toMediaTypeOrNull())
        val telefonoData = formulario.telefono.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_visitaData = formulario.tipo_visita.toRequestBody(contentType.toMediaTypeOrNull())
        val cl_visitaData = formulario.cl_visita.toRequestBody(contentType.toMediaTypeOrNull())
        val causaData = formulario.causa.toRequestBody(contentType.toMediaTypeOrNull())
        val direccionData = formulario.direccion.toRequestBody(contentType.toMediaTypeOrNull())
        val barrioData = formulario.barrio.toRequestBody(contentType.toMediaTypeOrNull())
        val propiedadData = formulario.propiedad.toRequestBody(contentType.toMediaTypeOrNull())
        val tensionaData = formulario.tensiona.toRequestBody(contentType.toMediaTypeOrNull())
        val tipo_taData = formulario.tipo_ta.toRequestBody(contentType.toMediaTypeOrNull())
        val toma_taData = formulario.toma_ta.toRequestBody(contentType.toMediaTypeOrNull())
        val resultado_taData = formulario.resultado_ta.toRequestBody(contentType.toMediaTypeOrNull())
        val oximetriaData = formulario.oximetria.toRequestBody(contentType.toMediaTypeOrNull())
        val toma_oxiData = formulario.toma_oxi.toRequestBody(contentType.toMediaTypeOrNull())
        val resultado_oxiData = formulario.resultado_oxi.toRequestBody(contentType.toMediaTypeOrNull())
        val findriskData = formulario.findrisk.toRequestBody(contentType.toMediaTypeOrNull())
        val estaturaData = formulario.estatura.toRequestBody(contentType.toMediaTypeOrNull())
        val pesoData = formulario.peso.toRequestBody(contentType.toMediaTypeOrNull())
        val nota_unoData = formulario.nota_uno.toRequestBody(contentType.toMediaTypeOrNull())

        return formularioService.updateWithImage(fileFormData, id, estadoData, name_medData, nameData, tipo_documentoData, num_documentoData, sexoData, RHData, fechaData,
            telefonoData, tipo_visitaData, cl_visitaData, causaData, direccionData, barrioData, propiedadData, tensionaData, tipo_taData, toma_taData, resultado_taData,
            oximetriaData, toma_oxiData, resultado_oxiData, findriskData, estaturaData, pesoData, nota_unoData)
    }

    override suspend fun delete(id: String): Response<Unit> = formularioService.delete(id)


}
