package net.thebix.parkser.navigation

import android.content.Context
import android.support.annotation.NonNull
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import java.util.LinkedList

class NavigationUtility {

    companion object {

        fun goTo(@NonNull context: Context, @NonNull viewKey: BaseKey) {
            Navigator.getBackstack(checkNotNull(context, { "context" }))
                    .goTo(checkNotNull(viewKey, { "viewKey" }))
        }

        fun goBack(@NonNull context: Context) {
            Navigator.getBackstack(checkNotNull(context, { "context" }))
                    .goBack()
        }

        fun resetHistory(@NonNull context: Context, @NonNull viewKey: BaseKey) {
            checkNotNull(context, { "context" })
            checkNotNull(viewKey, { "viewKey" })

            val history = LinkedList<Any>()
            history.add(viewKey)
            Navigator.getBackstack(context).setHistory(history, StateChange.REPLACE)
        }

        fun <T> getKey(@NonNull context: Context): T = Backstack.getKey<T>(context)
    }
}
