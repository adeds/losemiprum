package id.adeds.losemiprum.di

import dagger.Module
import dagger.Provides
import id.adeds.core.loader.FeatureManager
import id.adeds.core.loader.HomeFeature
import id.adeds.losemiprum.navigation.HomeModule
import javax.inject.Singleton

@Module
class FeatureModule {
    @Provides
    @Singleton
    fun provideInboxModule(
        featureManager: FeatureManager,
        profileDependencies: HomeFeature.Dependencies
    ) = HomeModule(featureManager, profileDependencies)

    @Provides
    @Singleton
    fun provideHomeFeatureDependencies() = object : HomeFeature.Dependencies {

    }
}