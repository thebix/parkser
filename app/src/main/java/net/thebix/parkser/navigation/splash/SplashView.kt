package net.thebix.parkser.navigation.splash

import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface SplashView {

    fun getRedirect(): Observable<SplashKey.RedirectTypes>
    fun proceedRedirect(): (Observable<SplashKey.RedirectTypes>) -> Disposable
}
