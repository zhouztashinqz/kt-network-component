package com.snowofsunflower.android.network.http.protocol

class ResultListWrapper<T>(status: Int, msg: String,
                           var data: List<T>? = null) : Result(status, msg)