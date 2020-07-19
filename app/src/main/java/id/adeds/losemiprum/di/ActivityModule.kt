package id.adeds.losemiprum.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.adeds.losemiprum.MainActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}