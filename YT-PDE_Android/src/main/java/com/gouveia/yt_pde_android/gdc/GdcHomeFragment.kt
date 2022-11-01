package com.gouveia.yt_pde_android.gdc

import android.os.Bundle
import android.view.View
import com.gouveia.yt_pde_android.R
import com.gouveia.yt_pde_android.databinding.FragmentGdcHomeBinding
import com.gouveia.yt_pde_android.util.navTo

class GdcHomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_gdc_home) {

    private lateinit var binding: FragmentGdcHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGdcHomeBinding.bind(view)

        binding.codelabToastSnake.setOnClickListener { navTo(R.id.toastSnakeFragment) }

    }

}