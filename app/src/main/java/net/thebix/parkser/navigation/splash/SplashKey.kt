package net.thebix.parkser.navigation.splash

import net.thebix.parkser.R
import net.thebix.parkser.navigation.BaseKey
import paperparcel.PaperParcel

@PaperParcel
data class SplashKey(val redirectType: RedirectTypes = RedirectTypes.UNKNOWN) : BaseKey() {

    companion object {
        @JvmField
        val CREATOR = PaperParcelSplashKey.CREATOR
    }

    enum class RedirectTypes {
        CAMERAS_LIST_SCREEN,
        UNKNOWN
    }

    override fun title() = R.string.navigation_splash_title

    override fun layout() = R.layout.navigation_splash_view
}
