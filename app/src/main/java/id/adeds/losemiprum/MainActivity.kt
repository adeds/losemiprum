package id.adeds.losemiprum

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import id.adeds.losemiprum.home.HomeFragment

class MainActivity : SimpleNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(HomeFragment())
        }
    }
}