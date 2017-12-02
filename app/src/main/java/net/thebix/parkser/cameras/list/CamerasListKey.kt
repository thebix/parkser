package net.thebix.parkser.cameras.list

import net.thebix.parkser.R
import net.thebix.parkser.navigation.BaseKey
import paperparcel.PaperParcel

@PaperParcel
class CamerasListKey : BaseKey() {

    companion object {
        @JvmField
        val CREATOR = PaperParcelCamerasListKey.CREATOR
    }

    override fun title() = R.string.cameras_list_title

    override fun layout() = R.layout.cameras_list_view
}
