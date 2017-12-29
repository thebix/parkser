package net.thebix.parkser.kotlin

import android.support.annotation.NonNull
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.RequestCreator
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import net.thebix.parkser.api.states.RequestComplete
import net.thebix.parkser.api.states.RequestError
import net.thebix.parkser.api.states.RequestStart
import net.thebix.parkser.api.states.RequestState

fun <T> rxUi(@NonNull uiAction: (T) -> Unit, @NonNull scheduler: Scheduler): (Observable<T>) -> Disposable = {
    it.observeOn(scheduler)
            .subscribe(uiAction)
}

fun <T : Any> rxBind(@NonNull observable: Observable<T>, @NonNull uiAction: (Observable<T>) -> Disposable): Disposable {
    return uiAction.invoke(observable)
}

// TODO: delme
//fun ImageView.load(@NonNull path: String, request: (RequestCreator) -> RequestCreator)
//        : Observable<out RequestState> {
//    return Observable.create<RequestState>({
//        request(context.picasso.load(path)).into(this, PicassoCallback(it))
//
//    }).startWith(RequestStart())
//}

fun ImageView.load(@NonNull path: String, request: (RequestCreator) -> RequestCreator)
        : Observable<out RequestState> {
    return Observable.create<RequestState>({
        request(context.picasso.load(path)).into(this, object : Callback {
            override fun onSuccess() {
                it.onNext(RequestComplete<Unit>(null))
            }

            override fun onError() {
                it.onNext(RequestError(Throwable()))
            }

        })

    }).startWith(RequestStart())
}
