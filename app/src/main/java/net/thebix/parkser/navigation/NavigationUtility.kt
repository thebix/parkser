package net.thebix.parkser.navigation

import android.content.Context
import android.support.annotation.NonNull
import com.zhuinden.simplestack.navigator.Navigator

class NavigationUtility {
    companion object {
        fun goTo(@NonNull context: Context, @NonNull viewKey: BaseKey) {
            // TODO: preconditions check
            Navigator.getBackstack(context).goTo(viewKey)
        }
        fun goBack(@NonNull context: Context) {
            // TODO: preconditions check
            Navigator.getBackstack(context).goBack()
        }
    }
}