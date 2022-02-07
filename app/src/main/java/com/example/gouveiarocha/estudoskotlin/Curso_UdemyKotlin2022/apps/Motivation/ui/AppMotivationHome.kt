package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.infra.MotivationConstants
import com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.infra.SecurityPreferences
import com.example.gouveiarocha.estudoskotlin.R
import kotlinx.android.synthetic.main.appmotivation_act_home.*

class AppMotivationHome : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appmotivation_act_home)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)
        appmotivation_btn_save.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.appmotivation_btn_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = appmotivation_edit_name.text.toString()
        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, AppMotivationMain::class.java))
        } else {
            Toast.makeText(this, "Atenção: Digite seu nome para continuar...", Toast.LENGTH_SHORT).show()
        }
    }
}