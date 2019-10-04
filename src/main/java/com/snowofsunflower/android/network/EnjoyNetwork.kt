package com.snowofsunflower.android.network

import com.snowofsunflower.android.network.http.builder.RetrofitBuilder
import com.snowofsunflower.android.network.http.builder.RetrofitJunitBuilder
import okhttp3.Interceptor

/**
 * Refactor by Zhouztashin on 2018/4/16
 * Http服务类工厂
 */
class EnjoyNetwork {
    companion object {
        private val sBaseRetrofitBuilder = RetrofitBuilder()
        private val sRetrofitJunitBuilder = RetrofitJunitBuilder()

        /**
         * 生成网络访问服务类。
         *
         * @param serviceInterface
         * @param url
         * @param <T>
         * @return
         */
        fun <T> createHttpService(serviceInterface: Class<T>, url: String) =
                sBaseRetrofitBuilder.createServiceFrom(serviceInterface, url)

        /***
         * 生成用于单元测试的网络访问服务类。
         * @param serviceInterface
         * @param url
         * @param <T>
         * @return
         */
        fun <T> createHttpServiceForJunit(serviceInterface: Class<T>, url: String) =
                sRetrofitJunitBuilder.createServiceFrom(serviceInterface, url)

        /**
         * 设置拦截器
         *
         * @param list
         */
        fun addHttpServiceInteceptor(list: List<Interceptor>) {
            for (interceptor in list) {
                sBaseRetrofitBuilder.addInterceptor(interceptor)
            }

        }
    }
}
