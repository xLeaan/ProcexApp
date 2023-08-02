package com.procex.procexapp.domain.util

import android.util.Log
import com.procex.procexapp.domain.model.ErrorResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody

object ConvertErrorBody {

    fun convert(errorBody: ResponseBody?): ErrorResponse? {
        return try{

            errorBody?.source().let{
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }


        } catch (e: Exception){
            Log.d("ConvertErrorBody", "Error: " + e.message)
            null
        }
    }

}