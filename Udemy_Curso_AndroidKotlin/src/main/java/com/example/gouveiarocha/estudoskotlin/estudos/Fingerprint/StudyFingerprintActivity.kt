package com.example.gouveiarocha.estudoskotlin.estudos.Fingerprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gouveiarocha.estudoskotlin.R

class StudyFingerprintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_fingerprint)

        val biometricAvailable = BiometricHelper.isBiometricAvailable(this)

    }
}