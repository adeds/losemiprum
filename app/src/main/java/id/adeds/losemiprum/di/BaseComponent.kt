package id.adeds.losemiprum.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import id.adeds.losemiprum.BaseApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        BaseModule::class,
        AndroidInjectionModule::class,
        ActivityModule::class,
        FeatureModule::class
    ]
)
interface BaseComponent : AndroidInjector<BaseApp>