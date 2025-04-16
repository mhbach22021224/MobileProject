package com.example.application

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
     private const val Base_URL = "https://api.dictionaryapi.dev/api/v2/entries/"

     private fun getInstance() : Retrofit {
         return Retrofit.Builder()
             .baseUrl(Base_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }

     val dictionaryAPI : DictionaryAPI = getInstance().create(DictionaryAPI::class.java)
}