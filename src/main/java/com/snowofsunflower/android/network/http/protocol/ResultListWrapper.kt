package com.snowofsunflower.android.network.http.protocol

/**
 * 访问响应列表实体
 */
class ResultListWrapper<T>(status: Int, msg: String,
                           var data: List<T>? = null) : Result(status, msg)