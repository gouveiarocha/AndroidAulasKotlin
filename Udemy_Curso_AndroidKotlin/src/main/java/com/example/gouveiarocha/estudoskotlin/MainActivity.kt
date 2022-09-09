package com.example.gouveiarocha.estudoskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gouveiarocha.estudoskotlin.estudos.Elementos_Secoes_19_38.StudyElementsActivity2
import com.example.gouveiarocha.estudoskotlin.estudos.Fingerprint.StudyFingerprintActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, StudyElementsActivity2::class.java))

    }

}