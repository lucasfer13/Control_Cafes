package com.example.cafes.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Adapter API
 * @author Lucas
 * */
class APIAdapter {
    companion object {
        private val url : String = "http://10.0.1.45:8080/"
        private var service : APIService? = null

        /**
         * Funcion que retorna el servicio de la API
         * @return Servicio de la API
         * */
        fun getApiService() : APIService? {
            //val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor()
            //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client : OkHttpClient.Builder = OkHttpClient.Builder()
            //client.addInterceptor(interceptor = interceptor)

            if (service == null) {
                val retrofit : Retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build()

                service = retrofit.create(APIService::class.java)
            }
            return service
        }

    }
}