package net.thebix.parkser.navigation.splash

import android.support.annotation.NonNull
import io.reactivex.disposables.CompositeDisposable
import net.thebix.parkser.kotlin.rxBind

class SplashViewPresenter {

    fun bind(@NonNull splashView: SplashView): CompositeDisposable {
        checkNotNull(splashView, { "splashView" })

        val compositeDisposable = CompositeDisposable()
        rxBind(splashView.getRedirect(), splashView.proceedRedirect())
        return compositeDisposable
    }
}
