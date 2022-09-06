package com.example.paralelos.studies.DynamicFeature

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.paralelos.BuildConfig
import com.example.paralelos.R
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

const val REQUIRES_USER_CONFIRMATION_CODE = 9528

class DinamycFeatureStudy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinamyc_feature_study)

        val moduleRequest = SplitInstallRequest
            .newBuilder()
            .addModule("EstudosParalelos_DynamicFeature")
            .build()

        val splitManager = SplitInstallManagerFactory.create(this)
        splitManager.startInstall(moduleRequest)
            // Callback de sucesso
            .addOnSuccessListener {

            }
            // Callback de erro
            .addOnFailureListener {

            }
            // Callback para quando o processo for finalizado (com erro ou com sucesso)
            .addOnCompleteListener {

            }



        val listener = SplitInstallStateUpdatedListener { state ->

            state.moduleNames().joinToString(" - ")
            when (state.status()) {
                SplitInstallSessionStatus.DOWNLOADING -> {
                    //  In order to see this, the application has to be uploaded to the Play Store.
                    Log.d("MANAGER_LISTENER", "Downloading")
                }

                SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                    /*
                      This may occur when attempting to download a sufficiently large module.
                      In order to see this, the application has to be uploaded to the Play Store.
                      Then features can be requested until the confirmation path is triggered.
                     */
                    Log.d("MANAGER_LISTENER", "Requires User confirmation")
                    splitManager.startConfirmationDialogForResult(state, this, REQUIRES_USER_CONFIRMATION_CODE)
                }

                SplitInstallSessionStatus.INSTALLED -> {
                    Log.d("MANAGER_LISTENER", "Installed")
                }

                SplitInstallSessionStatus.INSTALLING -> {
                    Log.d("MANAGER_LISTENER", "Installing")
                }

                SplitInstallSessionStatus.FAILED -> {
                    Log.d("MANAGER_LISTENER", "Failed")
                }

                else  -> {
                    Log.d("MANAGER_LISTENER", "Unknown state: ${state.status()}")
                }
            }
        }

        // Registrando o listener
        splitManager.registerListener(listener)

        // Abrindo Activity do Módulo.
        if (splitManager.installedModules.contains("EstudosParalelos_DynamicFeature")) {
            val i = Intent()
            i.setClassName(BuildConfig.APPLICATION_ID, "com.example.estudo_dynamicfeature.MainActivity")
            startActivity(i)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUIRES_USER_CONFIRMATION_CODE) {
            // Aqui você pode fazer alguma ação antes de verificar qual foi a resposta do usuário

            if (resultCode == Activity.RESULT_CANCELED) {
                // Código para tratar o cancelamento do download do módulo
            } else {
                // Código para tratar o aceite do módulo
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

}