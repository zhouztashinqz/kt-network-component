package com.snowofsunflower.android.network.http.builder

import okhttp3.Dispatcher
import java.util.concurrent.Executors

class RetrofitJunitBuilder : RetrofitBuilder() {
    override fun dispatcher() = Dispatcher(Executors.newSingleThreadExecutor())
}