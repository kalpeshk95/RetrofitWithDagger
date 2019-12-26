package com.retrofit.data.remote

import com.retrofit.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {

                val interceptor = HttpLoggingInterceptor()
                interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                val client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/v2/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit
        }
}
