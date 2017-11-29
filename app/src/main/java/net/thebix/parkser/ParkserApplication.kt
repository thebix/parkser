// https://github.com/damianpetla/kotlin-dagger-example/blob/master/app/src/main/java/org/loop/example/MyApplication.kt

package net.thebix.parkser

import android.app.Application
import net.thebix.parkser.dagger.AndroidModule
import net.thebix.parkser.dagger.ApplicationComponent
import net.thebix.parkser.dagger.DaggerApplicationComponent

class ParkserApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var mDaggerGraph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        mDaggerGraph = DaggerApplicationComponent.builder().androidModule(AndroidModule(this)).build()
        mDaggerGraph.inject(this)
    }
}
