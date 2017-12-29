package net.thebix.parkser.kotlin

import android.content.Context
import com.squareup.picasso.Picasso

val Context.picasso: Picasso
    get() = Picasso.with(this)

// TODO: delme
//class PicassoCallback(val emitter: ObservableEmitter<RequestState>) : Callback {
//
//    override fun onSuccess() {
//        emitter.onNext(RequestComplete<Unit>(null))
//    }
//
//    override fun onError() {
//        emitter.onNext(RequestError(Throwable()))
//    }
//}
