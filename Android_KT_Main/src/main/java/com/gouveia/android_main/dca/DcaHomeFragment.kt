package com.gouveia.android_main.dca

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gouveia.android_main.R
import com.gouveia.android_main.databinding.FragmentDcaHomeBinding
import com.gouveia.android_main.utils.extensions.hasInternet
import com.gouveia.android_main.utils.extensions.navTo
import com.gouveia.android_main.utils.extensions.showToast
import com.gouveia.android_main.utils.extensions.showYoutubeVideo

class DcaHomeFragment : Fragment(R.layout.fragment_dca_home) {

    private lateinit var binding: FragmentDcaHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDcaHomeBinding.bind(view)

        with(binding) {

            //SOLICITAR PERMISSÕES COM API NOVA DA GOOGLE: https://youtu.be/grYUKZDTzVA
            dcaRequestPermission.setOnClickListener { navTo(R.id.dcaRequestPermissionFragment) }

            //LANCAR ACTIVITY, FRAGMENTS E OBTER RESULTADO: https://youtu.be/mhm096S_qrA
            dcaRequestResult.setOnClickListener { navTo(R.id.dcaRequestResultFragment) }

            //ESCONDER TECLADO: https://youtu.be/OzK1fJi9FiQ
            //VIBRAR CELULAR: https://youtu.be/ogxgiaCq_24
            dcaKeyboardVibration.setOnClickListener { navTo(R.id.dcaKeyboardVibrationFragment) }

            //COMO BLOQUEAR / IMPEDIR CAPTURAS DE TELAS: https://youtu.be/7zUdUYiu8Rs
            dcaObfuscation.setOnClickListener { navTo(R.id.dcaObfuscationFragment) }

            //COMO VERIFICAR CONEXÃO COM INTERNET: https://youtu.be/DpyxLwibE0M
            dcaHasInternet.setOnClickListener { showToast(if (hasInternet()) "YES :)" else "NO :(") }

            //COMO CRIAR / GRAVAR VIDEOS DO ANDROID STUDIO: https://youtu.be/1vB46ujfVrA
            dcaCreateVideo.setOnClickListener { showYoutubeVideo("1vB46ujfVrA") }

            //COMO FORCAR DARK MODE NA WEB VIEW: https://youtu.be/aMuHOlTNL9E
            dcaWebViewDarkMode.setOnClickListener { navTo(R.id.dcaWebViewDarModeFragment) }

        }

    }

}