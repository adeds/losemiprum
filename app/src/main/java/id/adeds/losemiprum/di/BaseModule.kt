package id.adeds.losemiprum.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import id.adeds.core.api.UserApi
import id.adeds.core.interactor.UserInteractor
import id.adeds.core.loader.FeatureManager
import id.adeds.core.loader.createFeatureManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class BaseModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideFeatureManager(application: Application): FeatureManager =
        createFeatureManager(application)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit) = retrofit.create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideUserInteractor(userApi: UserApi) = UserInteractor(userApi)
}