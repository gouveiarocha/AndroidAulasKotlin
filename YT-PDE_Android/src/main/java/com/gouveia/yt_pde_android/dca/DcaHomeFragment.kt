package com.gouveia.yt_pde_android.dca

import android.os.Bundle
import android.view.View
import com.gouveia.yt_pde_android.R
import com.gouveia.yt_pde_android.databinding.FragmentDcaHomeBinding
import com.gouveia.yt_pde_android.util.navTo

class DcaHomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_dca_home) {

    private lateinit var binding: FragmentDcaHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDcaHomeBinding.bind(view)

        binding.requestPermission.setOnClickListener { navTo(R.id.requestPermissionFragment) }

    }

}