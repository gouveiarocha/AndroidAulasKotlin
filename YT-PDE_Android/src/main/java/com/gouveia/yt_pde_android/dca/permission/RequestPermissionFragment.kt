package com.gouveia.yt_pde_android.dca.permission

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.gouveia.yt_pde_android.R
import com.gouveia.yt_pde_android.databinding.FragmentRequestPermissionBinding
import com.gouveia.yt_pde_android.util.shouldRequestPermission
import com.gouveia.yt_pde_android.util.showToast

// Vídeo -> https://youtu.be/grYUKZDTzVA
// 1) DEFINIR PERMISSÕES NO MANIFEST
// 2) DEFINIR O LAUNCHER QUE VAI OFERECER UMA CAIXA DE DIALOGO AO USUÁRIO NO onCreate()
// 3) SOLICITAR PERMISSÕES INDICANDO QUAIS PERMISSÕES SÃO NECESSÁRIAS

class RequestPermissionFragment : Fragment(R.layout.fragment_request_permission) {

    private lateinit var binding: FragmentRequestPermissionBinding

    // NOVA API DE SOLICITACÃO DE PERMISSÕES QUE USA CALLBACKS
    private lateinit var activityResultLauncher: ActivityResultLauncher<Array<String>>

    // PERMISSÕES QUE IREMOS SOLICITAR AO USUÁRIO EM TEMPO DE EXECUÇÃO
    private val permissions = arrayOf(READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissionResult ->

            // O it(ou permissionResult) é um map com uma chave String(permissão) e um valor boolean(representando se a permissão foi concedidada ou não)

            // Usamos a chave do map para verificar se temos todas as permissões requisitadas.
            val permissionsIdentified = permissionResult.all {
                it.key in permissions
            }

            // Usamos o valor do map para verificar se todas as permissões foram liberadas
            val permissionsGrant = permissionResult.all {
                it.value
            }

            if (permissionsIdentified && permissionsGrant) {
                showToast("Permissões concedidas!")
            } else {
                // Pegamos quais permissões foram negadas.
                val deniedPermissions = permissionResult.map { perm ->
                    if (!perm.value) perm.key else ""
                }.filter { it.isNotEmpty() }.toList()
                showWhyPermissionsAreNeeded(deniedPermissions)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRequestPermissionBinding.bind(view)

        binding.requestPermissionButton.setOnClickListener {
            if (shouldRequestPermission(permissions)) {
                activityResultLauncher.launch(permissions)
            } else {
                showToast("Permissões já foram concedidas...")
            }
        }

    }

    // EXPLICA PORQUE AS PERMISSÕES SÃO NECESSÁRIAS AO USUÁRIO
    private fun showWhyPermissionsAreNeeded(deniedPermissions: List<String>) {
        val msg = StringBuilder()
        msg.append("READ_EXTERNAL_STORAGE \n")
        msg.append("WRITE_EXTERNAL_STORAGE \n")
        showToast("Você precisa nos conceder as permissões:\n$msg")
    }

}