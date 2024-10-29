package com.example.estudiantesapp.service

import com.example.estudiantesapp.model.Estudiante
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("estudiantes")
    fun obtenerEstudiantes(): Call<List<Estudiante>>

    companion object {
        private const val BASE_URL = "https://processing-rhode-civilian-indonesian.trycloudflare.com/"

        fun create(): ApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
