package com.gouveia.yt_pde_android.gdc

import android.os.Bundle
import android.view.View
import com.gouveia.yt_pde_android.R
import com.gouveia.yt_pde_android.databinding.FragmentGdcHomeBinding

class GdcHomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_gdc_home) {

    private lateinit var binding: FragmentGdcHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGdcHomeBinding.bind(view)
    }

}