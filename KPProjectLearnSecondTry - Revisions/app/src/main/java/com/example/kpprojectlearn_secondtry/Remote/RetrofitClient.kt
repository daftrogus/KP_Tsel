package com.example.kpprojectlearn_secondtry.Remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val jehson : Gson = GsonBuilder().setLenient().create()

    private var retrofit:Retrofit?=null
    fun getClient(baseUrl:String):Retrofit{
        if(retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(jehson))
                .build()
        }
        return retrofit!!
    }

}