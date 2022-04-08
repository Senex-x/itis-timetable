package com.senex.timetable.data.repository.remote

import com.senex.timetable.domain.util.log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

fun <T> continuationCallback(
    continuation: Continuation<T?>,
) = object : Callback<T> {

    override fun onResponse(
        call: Call<T>,
        response: Response<T>,
    ) = continuation.resume(response.body())

    override fun onFailure(
        call: Call<T>,
        t: Throwable
    ) {
        log(FAIL_MESSAGE)
        continuation.resume(null)
    }
}

fun <T> listContinuationCallback(
    continuation: Continuation<List<T>?>,
) = object : Callback<List<T>> {

    override fun onResponse(
        call: Call<List<T>>,
        response: Response<List<T>>,
    ) = continuation.resume(response.body())

    override fun onFailure(
        call: Call<List<T>>,
        t: Throwable,
    ) {
        log(FAIL_MESSAGE)
        continuation.resume(null)
    }
}

private const val FAIL_MESSAGE = "Server API request failed"