package com.example.data.base

import com.example.common.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal fun <T> makeNetworkRequest(
    gatherIsSucceed: ((T) -> Unit)? = null,
    request: suspend () -> T
) = flow<Either<String, T>> {
    request().also {
        gatherIsSucceed?.invoke(it)
        emit(Either.Right(value = it))
    }
}.flowOn(Dispatchers.IO).catch { exceptions ->
    emit(Either.Left(value = exceptions.localizedMessage ?: "Error Occurred!"))
}