package com.snowofsunflower.android.network.http.builder

import okhttp3.Dispatcher
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class RetrofitJunitBuilder : RetrofitBuilder() {
    override fun dispatcher() = Dispatcher(object : ExecutorService {
        override fun shutdown() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T : Any?> submit(task: Callable<T>): Future<T> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T : Any?> submit(task: Runnable, result: T): Future<T> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun submit(task: Runnable): Future<*> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun shutdownNow(): MutableList<Runnable> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isShutdown(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun awaitTermination(timeout: Long, unit: TimeUnit): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T : Any?> invokeAny(tasks: MutableCollection<out Callable<T>>): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T : Any?> invokeAny(tasks: MutableCollection<out Callable<T>>, timeout: Long, unit: TimeUnit): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isTerminated(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T : Any?> invokeAll(tasks: MutableCollection<out Callable<T>>): MutableList<Future<T>> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T : Any?> invokeAll(tasks: MutableCollection<out Callable<T>>, timeout: Long, unit: TimeUnit): MutableList<Future<T>> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun execute(command: Runnable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    })
}