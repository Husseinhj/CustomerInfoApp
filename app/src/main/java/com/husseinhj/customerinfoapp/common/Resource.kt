@file:Suppress("UNUSED_PARAMETER")

package com.husseinhj.customerinfoapp.common

sealed class Resource<T>(val data: T? = null, val error: String? = null) {

    class Loading<T>: Resource<T>()
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(error: String, code: Int): Resource<T>(error = error)

}