package net.thebix.parkser.test.dagger

import dagger.Module
import dagger.Provides
import net.thebix.parkser.test.TestApi
import retrofit2.Retrofit

@Module
class TestApiModule {
    @Provides
    fun provideTestApi(retrofit: Retrofit): TestApi {
        return retrofit.create(TestApi::class.java)
    }
}