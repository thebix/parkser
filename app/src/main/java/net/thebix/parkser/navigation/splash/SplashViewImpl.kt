package net.thebix.parkser.navigation.splash

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.widget.FrameLayout
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import net.thebix.parkser.cameras.list.CamerasListKey
import net.thebix.parkser.kotlin.rxUi
import net.thebix.parkser.navigation.NavigationUtility
import java.util.concurrent.TimeUnit

class SplashViewImpl(
        @NonNull context: Context,
        @Nullable attrs: AttributeSet?)
    : FrameLayout(context, attrs), SplashView {

    private lateinit var mPresenter: SplashViewPresenter
    private lateinit var mCompositeDisposable: CompositeDisposable
    private lateinit var mSplashKey: SplashKey

    init {
        checkNotNull(context, { "context" })
        if (!isInEditMode) {
            mCompositeDisposable = CompositeDisposable()
            mPresenter = SplashViewPresenter()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (isInEditMode) return
        mSplashKey = NavigationUtility.getKey(context)
        mCompositeDisposable.add(mPresenter.bind(this))
    }

    override fun onDetachedFromWindow() {
        if (!isInEditMode) {
            mCompositeDisposable.dispose()

        }
        super.onDetachedFromWindow()
    }

    override fun getRedirect(): Observable<SplashKey.RedirectTypes> {
        return Observable.just(mSplashKey.redirectType)
                //TODO: remove it, just to show the splash screen a bit longer
                .delay(2, TimeUnit.SECONDS)
    }

    override fun proceedRedirect(): (observable: Observable<SplashKey.RedirectTypes>) -> Disposable = rxUi({ redirectType ->
        when (redirectType) {
            SplashKey.RedirectTypes.CAMERAS_LIST_SCREEN -> NavigationUtility.resetHistory(context, CamerasListKey())
        }

    }, mainThread())
}
