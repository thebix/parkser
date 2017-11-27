package net.thebix.parkser.navigation

import net.thebix.parkser.R
import paperparcel.PaperParcel

@PaperParcel
data class SplashKey(val testParam: String = "") : BaseKey() {

    companion object {
        @JvmField
        val CREATOR = PaperParcelSplashKey.CREATOR
    }

    override fun title() = R.string.navigation_splash_title

    override fun layout() = R.layout.navigation_splash_view
}