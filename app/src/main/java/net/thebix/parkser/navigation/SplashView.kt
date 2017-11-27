package net.thebix.parkser.navigation

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.jakewharton.rxbinding2.view.RxView
import com.zhuinden.simplestack.Backstack
import io.reactivex.disposables.CompositeDisposable
import net.thebix.parkser.R
import net.thebix.parkser.cameras.list.CamerasListKey
import net.thebix.parkser.kotlin.bindView

class SplashView(
        @NonNull context: Context,
        @Nullable attrs: AttributeSet?)
    : LinearLayout(context, attrs) {

    val mTitle: TextView by bindView(R.id.navigation_splash_title)

    private lateinit var mSplashScreenKey: SplashKey
    private lateinit var mCompositeDisposable: CompositeDisposable

    init {
        // TODO: preconditions of context
        if (!isInEditMode) {
            mSplashScreenKey = Backstack.getKey(context)
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
//        ButterKnife.bind(this)
        mTitle.text = mSplashScreenKey.testParam
        mCompositeDisposable = CompositeDisposable(
                RxView.clicks(mTitle).subscribe({
                    mTitle.text = context.getString(R.string.navigation_splash_title)
                    NavigationUtility.goTo(context, CamerasListKey(""))
                }))
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        if (!isInEditMode) {
            mCompositeDisposable.dispose()

        }
        super.onDetachedFromWindow()
    }
}