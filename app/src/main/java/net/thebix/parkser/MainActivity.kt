package net.thebix.parkser

import android.os.Bundle
import net.thebix.parkser.navigation.BaseKey
import net.thebix.parkser.navigation.NavigationActivity
import net.thebix.parkser.navigation.SplashKey

class MainActivity : NavigationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getDefaultViewKey(): BaseKey = SplashKey()
}
