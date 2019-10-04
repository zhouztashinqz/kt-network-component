package com.snowofsunflower.android.network.http.builder

import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by zhouztashin on 2018/4/17.
 * RetrofitService生成器
 */
open class RetrofitBuilder(val mInterceptor: ArrayList<Interceptor> = arrayListOf()) {

    fun addInterceptor(interceptor: Interceptor) = mInterceptor.add(interceptor)

    fun <T> createServiceFrom(serviceClass: Class<T>, endPoint: String): T {
        val retrofit = getRetrofitBuilder(endPoint).build()
        return retrofit.create(serviceClass)
    }

    private fun getRetrofitBuilder(endPoint: String): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLogClient())
    }

    private fun getLogClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        val builder = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(45, TimeUnit.SECONDS)
                .writeTimeout(45, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .dispatcher(dispatcher())
        for (interceptor in mInterceptor) {
            builder.addInterceptor(interceptor)
        }
        return builder.build()
    }

    open fun dispatcher() = Dispatcher()
}