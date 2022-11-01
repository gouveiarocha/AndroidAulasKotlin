package com.gouveia.yt_pde_android

import android.os.Bundle
import android.view.View
import com.gouveia.yt_pde_android.databinding.FragmentMainBinding
import com.gouveia.yt_pde_android.util.navTo

class MainFragment : androidx.fragment.app.Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.btnGdc.setOnClickListener { navTo(R.id.gdcHomeFragment) }
        binding.btnDesafios.setOnClickListener { navTo(R.id.challengeHomeFragment) }

    }

}