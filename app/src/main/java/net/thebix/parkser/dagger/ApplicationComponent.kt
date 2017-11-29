package net.thebix.parkser.dagger

import dagger.Component
import net.thebix.parkser.MainActivity
import net.thebix.parkser.ParkserApplication
import net.thebix.parkser.navigation.SplashView
import net.thebix.parkser.test.dagger.TestApiModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, ApiModule::class, TestApiModule::class))
interface ApplicationComponent {
    fun inject(application: ParkserApplication)

    fun inject(mainActivity: MainActivity)

    fun inject(splashView: SplashView)
}
