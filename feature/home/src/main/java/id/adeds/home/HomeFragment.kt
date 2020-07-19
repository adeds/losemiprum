package id.adeds.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import coil.api.load
import coil.transform.CircleCropTransformation
import id.adeds.home.databinding.FragmentHomeBinding
import id.adeds.losemiprum.viewmodel.*

class HomeFragment : RainbowCakeFragment<HomeViewState, HomeViewModel>() {
    override fun getViewResource() = 0

    override fun provideViewModel() = getViewModelFromFactory()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun render(viewState: HomeViewState) {
        when (viewState) {
            is Loading -> {
                binding.viewFlipper.displayedChild = 0
            }
            is UserReady -> {
                binding.viewFlipper.displayedChild = 1

                binding.tvUserLogin.text = viewState.data.name
                binding.ivUserProfile.load(viewState.data.avatar_url) {
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

    @SuppressLint("MissingSuperCall")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return _binding!!.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}