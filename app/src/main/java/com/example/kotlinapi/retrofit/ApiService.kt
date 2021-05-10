package com.example.kotlinapi.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
  val BASEURL: String = "https://demo.lazday.com/rest-api-sample/"
  val endpoint: ApiEndpoint
  get(){

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
      .addInterceptor(interceptor)
      .build()

    val retrofit = Retrofit.Builder()
      .baseUrl(BASEURL)
      .client(client)
      .addConverterFactory(GsonConverterFactory.create())
      .build()


    return retrofit.create(ApiEndpoint::class.java)
  }
}