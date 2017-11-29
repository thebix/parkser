package net.thebix.parkser.api.states

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import retrofit2.Response

fun <T : Any> requestStateTransformer(): ObservableTransformer<Response<T>, RequestState> =
        ObservableTransformer<Response<T>, RequestState> { upstream ->
            Observable.concatArray(Observable.just(RequestStart()),
                    upstream.flatMap { response ->
                        if (response.isSuccessful) {
                            Observable.just(RequestComplete(response.body()))
                        } else {
                            Observable.just((RequestError(Throwable(response.errorBody().toString()))))
                        }
                    }
                    // TODO: .onErrorResumeNext(ERROR))
            )
        }
