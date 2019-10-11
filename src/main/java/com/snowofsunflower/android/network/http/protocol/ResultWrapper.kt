package com.snowofsunflower.android.network.http.protocol

/**
 * Created by zhouztashin on 2018/11/2.
 * 访问响应实体
 */
class ResultWrapper<T>(status: Int, msg: String
                       , var obj: T? = null) : Result(status, msg)