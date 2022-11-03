package com.gouveia.android_main.dca.start_for_result

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.bumptech.glide.Glide
import com.gouveia.android_main.R
import com.gouveia.android_main.databinding.FragmentDcaResultBinding
import com.gouveia.android_main.dca.start_for_result.DcaRequestResultFragment.Companion.KEY_CHOOSER_BACK_BUTTON
import com.gouveia.android_main.dca.start_for_result.DcaRequestResultFragment.Companion.KEY_CHOOSER_REQUEST
import com.gouveia.android_main.utils.extensions.navBack
import com.gouveia.android_main.utils.others.WayConstans

class DcaResultFragment : Fragment(R.layout.fragment_dca_result) {

    private lateinit var binding: FragmentDcaResultBinding

    // A CLASSE QUE RECEBE ARGUMENTOS É A CLASSE QUE DISPONIBILIZA AS KEYS
    companion object {
        const val KEY_SELECTED_IMAGE_URI = "key_selected_image_uri"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logWay("onViewCreated $this")
        binding = FragmentDcaResultBinding.bind(view)

        // PEGAR ENDERECO DA IMAGEM E EXIBI-LA NA TELA
        val imageUriExtra = arguments?.getString(KEY_SELECTED_IMAGE_URI)
        Glide.with(this).load(imageUriExtra).into(binding.imageView)

        binding.navBack.setOnClickListener {
            // DEVOLVER RESULTADO PARA TELA ANTERIOR
            setFragmentResult(
                KEY_CHOOSER_REQUEST,
                bundleOf(KEY_CHOOSER_BACK_BUTTON to "PRESSIONEI VOLTAR")
            )
            navBack()
        }
    }

    private fun logWay(msg: String) {
        Log.i(WayConstans.Dca.REQUEST_RESULT, msg)
    }

}