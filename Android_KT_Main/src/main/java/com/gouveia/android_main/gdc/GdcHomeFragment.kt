package com.gouveia.android_main.gdc

import android.os.Bundle
import android.view.View
import com.gouveia.android_main.R
import com.gouveia.android_main.databinding.FragmentGdcHomeBinding
import com.gouveia.android_main.utils.extensions.navTo

class GdcHomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_gdc_home) {

    private lateinit var binding: FragmentGdcHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGdcHomeBinding.bind(view)

        binding.gdcToastSnake.setOnClickListener { navTo(R.id.toastSnakeFragment) }

    }

}