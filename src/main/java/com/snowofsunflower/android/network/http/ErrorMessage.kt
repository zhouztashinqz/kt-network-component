package com.snowofsunflower.android.network.http

/**
 * 服务器错误信息
 */
class ErrorMessage {
    companion object {
        const val SERVICE_BUSY = "服务器繁忙"
        const val PROTOCOL_ERROR = "协议解析错误"
        const val HTTP_ERROR = "网络访问异常"
        const val CONNECT_ERROR = "网络访问失败，请检查网络"
        const val UNKNOWN_HOST = "网络访问失败，无法建立连接"
        const val CONNECT_TIMEOUT = "连接超时"
        const val SOCKET_ERROR = "连接失败"
    }

}