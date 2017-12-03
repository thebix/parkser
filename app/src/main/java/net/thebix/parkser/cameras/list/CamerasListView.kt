package net.thebix.parkser.cameras.list

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import net.thebix.parkser.api.states.RequestComplete
import net.thebix.parkser.api.states.RequestError
import net.thebix.parkser.api.states.RequestStart
import net.thebix.parkser.api.states.RequestState

interface CamerasListView {

    fun getCameras(): Observable<out RequestState>
    fun getCamerasStart(): (Observable<RequestStart>) -> Disposable
    fun getCamerasError(): (Observable<RequestError>) -> Disposable
    fun getCamerasCompleted(): (Observable<RequestComplete<Unit>>) -> Disposable
}
