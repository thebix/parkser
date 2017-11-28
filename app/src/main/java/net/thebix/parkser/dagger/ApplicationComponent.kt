package net.thebix.parkser.dagger

import dagger.Component
import net.thebix.parkser.MainActivity
import net.thebix.parkser.ParkserApplication
import net.thebix.parkser.navigation.SplashView
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface ApplicationComponent {
    fun inject(application: ParkserApplication)

    fun inject(mainActivity: MainActivity)

    fun inject(splashView: SplashView)
}
