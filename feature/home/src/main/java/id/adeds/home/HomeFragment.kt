package id.adeds.home

import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import coil.api.load
import coil.transform.CircleCropTransformation
import id.adeds.losemiprum.viewmodel.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : RainbowCakeFragment<HomeViewState, HomeViewModel>() {
    override fun getViewResource() = R.layout.fragment_home

    override fun provideViewModel() = getViewModelFromFactory()

    override fun render(viewState: HomeViewState) {
        when (viewState) {
            is Loading -> {
                viewFlipper.displayedChild = 0
            }
            is UserReady -> {
                viewFlipper.displayedChild = 1

                tvUserLogin.text = viewState.data.name
                ivUserProfile.load(viewState.data.avatar_url) {
                    crossfade(true)
                    placeholder(android.R.color.darker_gray)
                    transformations(CircleCropTransformation())
                }
            }
            is Error -> {
                Toast.makeText(requireContext(), viewState.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }


}