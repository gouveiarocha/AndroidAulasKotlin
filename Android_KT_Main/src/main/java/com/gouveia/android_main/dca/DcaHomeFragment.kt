package com.gouveia.android_main.dca

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gouveia.android_main.R
import com.gouveia.android_main.databinding.FragmentDcaHomeBinding
import com.gouveia.android_main.utils.extensions.navTo

class DcaHomeFragment : Fragment(R.layout.fragment_dca_home) {

    private lateinit var binding: FragmentDcaHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDcaHomeBinding.bind(view)

        binding.dcaRequestPermission.setOnClickListener { navTo(R.id.dcaRequestPermissionFragment) }
        binding.dcaRequestResult.setOnClickListener { navTo(R.id.dcaRequestResultFragment) }

    }

}