package net.thebix.parkser.cameras.list

import android.support.annotation.NonNull
import io.reactivex.disposables.CompositeDisposable
import net.thebix.parkser.api.states.RequestComplete
import net.thebix.parkser.api.states.RequestError
import net.thebix.parkser.api.states.RequestStart
import net.thebix.parkser.kotlin.rxBind

class CamerasListPresenter {

    fun bind(@NonNull view: CamerasListView): CompositeDisposable {
        checkNotNull(view, { "view" })

        val compositeDisposable = CompositeDisposable()

        val getCameras = view.getCameras().share()

        compositeDisposable.add(rxBind(
                getCameras.ofType(RequestStart::class.java),
                view.getCamerasStart()))

        compositeDisposable.add(rxBind(
                getCameras.ofType(RequestError::class.java),
                view.getCamerasError()
        ))

        compositeDisposable.add(rxBind(
                getCameras.filter({ it is RequestComplete<*> })
                        .map({
                            RequestComplete<Unit>(null)
                        })
                ,
                view.getCamerasCompleted()
        ))

        return compositeDisposable
    }
}
