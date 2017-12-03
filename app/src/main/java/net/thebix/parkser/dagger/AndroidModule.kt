// https://github.com/damianpetla/kotlin-dagger-example/blob/master/app/src/main/java/org/loop/example/AndroidModule.kt

package net.thebix.parkser.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import net.thebix.parkser.preferences.PreferencesManager
import javax.inject.Named
import javax.inject.Singleton

/**
 * A module for Android-specific dependencies which require a [android.content.Context] or [ ] to create.
 */
@Module
class AndroidModule(private val application: Application) {

    companion object {
        const val NAMED_CONTEXT: String = "context"
    }

    /**
     * Allow the application context to be injected but require that it be annotated with [ ][ForApplication] to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
//    @ForApplication
    @Named(AndroidModule.NAMED_CONTEXT)
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun providePreferencesManager(@Named(AndroidModule.NAMED_CONTEXT) context: Context) = PreferencesManager(context)
}
