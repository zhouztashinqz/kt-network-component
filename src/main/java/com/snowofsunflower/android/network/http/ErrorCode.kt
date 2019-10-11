package com.snowofsunflower.android.network.http

/**
 * 网络访问错误码
 */
enum class ErrorCode(val code: Int) {
    PROTOCOL_ERROR(-120), //协议解析错误
    JAVA_EXCEPTION(-130),//Java异常错误
    HTTP_RESPONSE_ERROR(-140),//网络响应错误
    NETWORK_ERROR(-150) //网络访问异常
}
