package com.gouveia.yt_pde_android.challenge

import android.os.Bundle
import android.view.View
import com.gouveia.yt_pde_android.R
import com.gouveia.yt_pde_android.databinding.FragmentChallengeHomeBinding

class ChallengeHomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_challenge_home) {

    private lateinit var binding: FragmentChallengeHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChallengeHomeBinding.bind(view)
    }

}