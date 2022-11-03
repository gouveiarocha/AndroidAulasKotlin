package com.gouveia.android_main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gouveia.android_main.databinding.FragmentMainBinding
import com.gouveia.android_main.utils.extensions.navTo

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.btnGdc.setOnClickListener { navTo(R.id.gdcHomeFragment) }
        binding.btnDca.setOnClickListener { navTo(R.id.dcaHomeFragment) }

    }

}