package com.gouveia.android_main.dca.keyboard_vibration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gouveia.android_main.R
import com.gouveia.android_main.databinding.FragmentDcaKeyboardVibrationBinding
import com.gouveia.android_main.utils.extensions.hideKeyboard
import com.gouveia.android_main.utils.extensions.showKeyboard
import com.gouveia.android_main.utils.extensions.vibrate

class DcaKeyboardVibrationFragment : Fragment(R.layout.fragment_dca_keyboard_vibration) {

    private lateinit var binding: FragmentDcaKeyboardVibrationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDcaKeyboardVibrationBinding.bind(view)

        with(binding) {
            dcaHideKeyboardButton.setOnClickListener { hideKeyboard() }
            dcaShowKeyboardButton.setOnClickListener { showKeyboard() }
            dcaVibrateButton.setOnClickListener { vibrate(1000) }
        }

    }

}