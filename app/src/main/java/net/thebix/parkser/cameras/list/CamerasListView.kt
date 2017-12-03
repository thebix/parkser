package net.thebix.parkser.cameras.list

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.widget.LinearLayout
import io.reactivex.disposables.CompositeDisposable
import net.thebix.parkser.ParkserApplication
import net.thebix.parkser.preferences.PreferencesManager
import javax.inject.Inject

class CamerasListView(
        @NonNull context: Context,
        @Nullable attrs: AttributeSet?)
    : LinearLayout(context, attrs) {

    //    val mTitle: TextView by bindView(R.id.navigation_splash_title)
    private lateinit var mCompositeDisposable: CompositeDisposable

    @field:[Inject]
    lateinit var mPreferencesManager: PreferencesManager

    init {
        checkNotNull(context, { "context" })
        if (!isInEditMode) {
            mCompositeDisposable = CompositeDisposable()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (isInEditMode) return
        ParkserApplication.mDaggerGraph.inject(this)
    }

    override fun onDetachedFromWindow() {
        if (!isInEditMode) {
            mCompositeDisposable.dispose()

        }
        super.onDetachedFromWindow()
    }
}
