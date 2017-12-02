package net.thebix.parkser.rx

import android.support.annotation.NonNull
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable

fun <T> rxUi(@NonNull uiAction: (T) -> Unit, @NonNull scheduler: Scheduler): (Observable<T>) -> Disposable = {
    it.observeOn(scheduler)
            .subscribe(uiAction)
}

fun <T> rxBind(@NonNull observable: Observable<T>, @NonNull uiAction: (Observable<T>) -> Disposable): Disposable {
    return uiAction.invoke(observable)
}
