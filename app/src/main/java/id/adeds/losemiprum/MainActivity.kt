package id.adeds.losemiprum

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import dagger.android.AndroidInjection
import id.adeds.core.loader.HomeFeature
import id.adeds.losemiprum.navigation.HomeModule
import javax.inject.Inject

class MainActivity : SimpleNavActivity() {

    @Inject
    lateinit var homeModule: HomeModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        if (savedInstanceState == null) {
            navigator.add(homeModule.getFeature().getMainScreen(HomeFeature.HOME_FRAGMENT))
        }
    }
}