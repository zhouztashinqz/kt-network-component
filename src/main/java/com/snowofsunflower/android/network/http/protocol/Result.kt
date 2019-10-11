package com.snowofsunflower.android.network.http.protocol

/**
 * Created by zhouztashin on 2018/11/2.
 * 访问网络响应基础实体
 */
open class Result(val status: Int, val msg: String) {
    val isSuccess: Boolean by lazy {
        status == 100
    }
}
