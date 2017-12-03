package net.thebix.parkser

import net.thebix.parkser.navigation.BaseKey
import net.thebix.parkser.navigation.NavigationActivity
import net.thebix.parkser.navigation.splash.SplashKey

class MainActivity : NavigationActivity() {

    override fun getDefaultViewKey(): BaseKey = SplashKey(SplashKey.RedirectTypes.CAMERAS_LIST_SCREEN)
}
