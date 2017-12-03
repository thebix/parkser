package net.thebix.parkser.cameras.list

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import net.thebix.parkser.ParkserApplication
import net.thebix.parkser.R
import net.thebix.parkser.api.states.RequestComplete
import net.thebix.parkser.api.states.RequestError
import net.thebix.parkser.api.states.RequestStart
import net.thebix.parkser.api.states.RequestState
import net.thebix.parkser.kotlin.bindView
import net.thebix.parkser.kotlin.load
import net.thebix.parkser.kotlin.rxUi
import net.thebix.parkser.preferences.PreferencesManager
import javax.inject.Inject

class CamerasListViewImpl(
        @NonNull context: Context,
        @Nullable attrs: AttributeSet?)
    : LinearLayout(context, attrs), CamerasListView {

    val mTitle: TextView by bindView(R.id.cameras_list_title)
    val mTestImage: ImageView by bindView(R.id.cameras_list_cameras_item)

    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    private val mPresenter: CamerasListPresenter = CamerasListPresenter()

    @field:[Inject]
    lateinit var mPreferencesManager: PreferencesManager

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (isInEditMode) return
        ParkserApplication.mDaggerGraph.inject(this)
        mCompositeDisposable.add(mPresenter.bind(this))
    }

    override fun onDetachedFromWindow() {
        if (!isInEditMode) {
            mCompositeDisposable.dispose()
        }
        super.onDetachedFromWindow()
    }

    override fun getCameras(): Observable<out RequestState> {
        return mTestImage.load("http://lorempixel.com/400/200/", { requestCreator ->
            requestCreator.resize(800, 400)
        })
    }

    override fun getCamerasStart(): (Observable<RequestStart>) -> Disposable =
            rxUi({
                mTitle.text = "// TODO: Start"
            }, mainThread())

    override fun getCamerasError(): (Observable<RequestError>) -> Disposable =
            rxUi({
                mTitle.text = "// TODO: Error"
            }, mainThread())

    override fun getCamerasCompleted(): (Observable<RequestComplete<Unit>>) -> Disposable =
            rxUi({
                mTitle.text = "// TODO: Success"
            }, mainThread())
}
