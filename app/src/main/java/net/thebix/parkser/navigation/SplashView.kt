package net.thebix.parkser.navigation

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.widget.LinearLayout
import com.zhuinden.simplestack.Backstack

class SplashView(
        @NonNull context: Context,
        @Nullable attrs: AttributeSet? = null)
    : LinearLayout(context, attrs) {

    var mSplashScreenKey: SplashKey? = null

    init {
        // TODO: preconditions of context
        if (!isInEditMode) {
            mSplashScreenKey = Backstack.getKey(context)
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        // INFO: ButterKnife.bind(this);
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}