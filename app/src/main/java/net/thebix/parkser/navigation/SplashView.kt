package net.thebix.parkser.navigation

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.zhuinden.simplestack.Backstack
import io.reactivex.disposables.CompositeDisposable
import net.thebix.parkser.ParkserApplication
import net.thebix.parkser.R
import net.thebix.parkser.kotlin.bindView

class SplashView(
        @NonNull context: Context,
        @Nullable attrs: AttributeSet?)
    : LinearLayout(context, attrs) {
    val mTitle: TextView by bindView(R.id.navigation_splash_title)

    private lateinit var mSplashScreenKey: SplashKey
    private lateinit var mCompositeDisposable: CompositeDisposable

    init {
        checkNotNull(context, { "context" })
        if (!isInEditMode) {
            mSplashScreenKey = Backstack.getKey(context)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ParkserApplication.mDaggerGraph.inject(this)
        mTitle.text = mSplashScreenKey.testParam
    }

    override fun onDetachedFromWindow() {
        if (!isInEditMode) {
            mCompositeDisposable.dispose()

        }
        super.onDetachedFromWindow()
    }
}
