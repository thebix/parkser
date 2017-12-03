package net.thebix.parkser.kotlin

import android.content.Context
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import io.reactivex.ObservableEmitter
import net.thebix.parkser.api.states.RequestComplete
import net.thebix.parkser.api.states.RequestError
import net.thebix.parkser.api.states.RequestState

val Context.picasso: Picasso
    get() = Picasso.with(this)

class PicassoCallback(val emitter: ObservableEmitter<RequestState>) : Callback {

    override fun onSuccess() {
        emitter.onNext(RequestComplete<Unit>(null))
    }

    override fun onError() {
        emitter.onNext(RequestError(Throwable()))
    }
}
