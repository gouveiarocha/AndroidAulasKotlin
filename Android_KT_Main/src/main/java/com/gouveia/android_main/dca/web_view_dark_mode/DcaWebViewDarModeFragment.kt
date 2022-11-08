package com.gouveia.android_main.dca.web_view_dark_mode

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.gouveia.android_main.R
import com.gouveia.android_main.databinding.FragmentDcaWebViewDarModeBinding

// REF DOCUMENTAÇÃO
// https://developer.android.com/reference/androidx/webkit/package-summary

class DcaWebViewDarModeFragment : Fragment(R.layout.fragment_dca_web_view_dar_mode) {

    private lateinit var binding: FragmentDcaWebViewDarModeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDcaWebViewDarModeBinding.bind(view)

        with(binding) {
            val mimeType = "text/html"
            val encoding = "utf-8"
            val htmlText = "<h3>Mude o Tema para Night Em Settings</h3>"
            forceDarkWebview.loadDataWithBaseURL(null, htmlText, mimeType, encoding, null)
            val inDarkMode = (requireContext().resources.configuration.uiMode and UI_MODE_NIGHT_MASK) == UI_MODE_NIGHT_YES
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK) && inDarkMode) {
                WebSettingsCompat.setForceDark(
                    forceDarkWebview.settings,
                    WebSettingsCompat.FORCE_DARK_ON
                )
            }
        }

    }

}