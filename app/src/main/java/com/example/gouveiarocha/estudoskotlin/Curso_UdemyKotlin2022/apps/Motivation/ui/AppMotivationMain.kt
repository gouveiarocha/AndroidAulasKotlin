package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.infra.MotivationConstants
import com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.infra.SecurityPreferences
import com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.Motivation.repository.MotivationMock
import com.example.gouveiarocha.estudoskotlin.R
import kotlinx.android.synthetic.main.appmotivation_act_main.*

class AppMotivationMain : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PRHASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appmotivation_act_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        appmotivation_image_all.setColorFilter(R.color.lightGreen)

        mSecurityPreferences = SecurityPreferences(this)

        appmotivation_button_new_phrase.setOnClickListener(this)
        appmotivation_image_all.setOnClickListener(this)
        appmotivation_image_happy.setOnClickListener(this)
        appmotivation_image_morning.setOnClickListener(this)

        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        appmotivation_text_user_name.text = "Olá, $name!"

        handleNewPhrase()

    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(
            R.id.appmotivation_image_all,
            R.id.appmotivation_image_happy,
            R.id.appmotivation_image_morning
        )
        if (id == R.id.appmotivation_button_new_phrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {
        when (id) {
            R.id.appmotivation_image_all -> {
                defaultColor()
                appmotivation_image_all.setColorFilter(R.color.grey)
                mPhraseFilter = MotivationConstants.PRHASEFILTER.ALL
            }
            R.id.appmotivation_image_happy -> {
                defaultColor()
                appmotivation_image_happy.setColorFilter(R.color.grey)
                mPhraseFilter = MotivationConstants.PRHASEFILTER.HAPPY
            }
            R.id.appmotivation_image_morning -> {
                defaultColor()
                appmotivation_image_morning.setColorFilter(R.color.grey)
                mPhraseFilter = MotivationConstants.PRHASEFILTER.MORNING
            }
        }
    }

    private fun handleNewPhrase() {
        appmotivation_text_phrase.text = MotivationMock().getPhrase(mPhraseFilter)
    }

    private fun defaultColor() {
        appmotivation_image_all.colorFilter = null
        appmotivation_image_happy.colorFilter = null
        appmotivation_image_morning.colorFilter = null
    }

}