package id.adeds.losemiprum

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import id.adeds.losemiprum.di.BaseModule
import id.adeds.losemiprum.di.DaggerBaseComponent
import javax.inject.Inject

class BaseApp : Application()
    , HasActivityInjector
//    , HasSupportFragmentInjector
{
    companion object {
        lateinit var instance: BaseApp
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

//    @Inject
//    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

//    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector


    private fun initializeDagger() {
        DaggerBaseComponent
            .builder()
            .baseModule(BaseModule(this))
            .build()
            .inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        instance = this
    }
}