package com.example.gouveiarocha.estudoskotlin.studies.Fingerprint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.gouveiarocha.estudoskotlin.R

class StudyFingerprintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_fingerprint)

        if (BiometricHelper.isBiometricAvailable(this)) {

            val executor = ContextCompat.getMainExecutor(this)
            val bio = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        // Ação de sucesso na autenticação.
                        val c = ""
                        super.onAuthenticationSucceeded(result)
                    }
                })

            val info = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Titulo")
                .setSubtitle("Subtitulo")
                .setDescription("Descrição")
                .setNegativeButtonText("Cancelar")
                .build()

            bio.authenticate(info)

        }

    }
}