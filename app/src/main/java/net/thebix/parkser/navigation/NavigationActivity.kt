package net.thebix.parkser.navigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.zhuinden.simplestack.HistoryBuilder
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import com.zhuinden.simplestack.navigator.DefaultStateChanger
import com.zhuinden.simplestack.navigator.Navigator

abstract class NavigationActivity : AppCompatActivity(), StateChanger {

    private val TAG = NavigationActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container = FrameLayout(this)
        setContentView(container)

        Navigator
                .configure()
                .setStateChanger(DefaultStateChanger.configure()
                        .setExternalStateChanger(this)
                        .create(this, container))
                .install(this, container, HistoryBuilder.single(getDefaultViewKey()))
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.topNewState<BaseKey>().equals(stateChange.topPreviousState())) {
            completionCallback.stateChangeComplete()
            return
        }
        val key = stateChange.topNewState<BaseKey>()
        setTitle(key.title())
        completionCallback.stateChangeComplete()
    }

    abstract fun getDefaultViewKey(): BaseKey
}
