package net.thebix.parkser.navigation

import android.support.annotation.LayoutRes
import android.support.annotation.NonNull
import com.zhuinden.simplestack.navigator.StateKey
import com.zhuinden.simplestack.navigator.ViewChangeHandler
import com.zhuinden.simplestack.navigator.changehandlers.NoOpViewChangeHandler
import paperparcel.PaperParcelable

abstract class BaseKey : StateKey, PaperParcelable {

    @NonNull
    override fun viewChangeHandler(): ViewChangeHandler {
        return NoOpViewChangeHandler()
    }

    @LayoutRes
    abstract override fun layout(): Int

    @LayoutRes
    abstract fun title(): Int
}