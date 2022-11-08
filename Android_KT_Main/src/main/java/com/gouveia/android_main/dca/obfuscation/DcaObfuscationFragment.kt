package com.gouveia.android_main.dca.obfuscation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gouveia.android_main.R
import com.gouveia.android_main.utils.extensions.setObfuscation
import com.gouveia.android_main.utils.extensions.showYoutubeVideo

class DcaObfuscationFragment : Fragment(R.layout.fragment_dca_obfuscation) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // OFUSCA A TELA AO CRIA-LA.
        setObfuscation(true)

    }

    override fun onDestroyView() {
        super.onDestroyView()

        // LIMPAR O OFUSCAMENTO
        // Se não fizermos isso, o ofuscamento ficará ativo na Activity e consequentemente ofuscar
        // telas que não deveria.
        setObfuscation(false)

    }

}