package com.snowofsunflower.android.network.http.callback

import android.util.MalformedJsonException
import com.google.gson.JsonSyntaxException
import com.snowofsunflower.android.network.http.ErrorCode
import com.snowofsunflower.android.network.http.ErrorMessage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException
import java.net.UnknownServiceException

/**
 * Created by zhouztashin on 2018/11/2.
 * 网络访问回调处理
 */
abstract class ResultCallback<T> : Callback<T> {

    override fun onResponse(call: retrofit2.Call<T>, response: retrofit2.Response<T>) {

        try {
            if (response.code() == 200) {
                var result: T? = response.body()
                if (result != null) {
                    success(result, response)
                } else {
                    var errorMsg: String? = response.errorBody()?.string()?.let {
                        ErrorMessage.PROTOCOL_ERROR
                    }
                    failure(ErrorCode.PROTOCOL_ERROR, errorMsg)
                }
            } else {
                failure(ErrorCode.HTTP_RESPONSE_ERROR,
                        "${ErrorMessage.HTTP_ERROR},响应码:${response.code()}")
            }
        } catch (e: Exception) {
            failure(ErrorCode.JAVA_EXCEPTION, e.message)
        }

    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        if (!call.isCanceled) {
            var failureMsg: String? = t.message
            var errorCode = ErrorCode.NETWORK_ERROR
            when (t) {
                is InterruptedException -> failureMsg = ErrorMessage.CONNECT_TIMEOUT
                is UnknownServiceException -> failureMsg = ErrorMessage.SERVICE_BUSY
                is UnknownHostException -> failureMsg = ErrorMessage.UNKNOWN_HOST
                is ConnectException -> failureMsg = ErrorMessage.CONNECT_ERROR
                is SocketException -> ErrorMessage.SOCKET_ERROR
                is JsonSyntaxException, is MalformedJsonException -> {
                    failureMsg = ErrorMessage.PROTOCOL_ERROR
                    errorCode = ErrorCode.PROTOCOL_ERROR
                }

            }
            failure(errorCode, failureMsg)
        }
    }

    /**
     * 网络访问、响应、协议解析成功时回调
     *
     * @param result
     * @param response
     */
    abstract fun success(result: T, response: Response<T>)

    /**
     * 网络访问失败、协议解析错误、Http响应错误、Java异常失败回调。
     *
     * @param code
     * @param message
     */
    abstract fun failure(code: ErrorCode, message: String?)
}