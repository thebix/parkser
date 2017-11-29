package net.thebix.parkser.navigation

import android.content.Context
import android.support.annotation.NonNull
import com.zhuinden.simplestack.navigator.Navigator

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
    }
}