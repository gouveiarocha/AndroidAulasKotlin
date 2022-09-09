package com.example.gouveiarocha.estudoskotlin.estudos.Elementos_Secoes_19_38

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gouveiarocha.estudoskotlin.R
import kotlinx.android.synthetic.main.activity_study_elements1.*

class StudyElementsActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_elements1)

        estudoelementos2_check_fill_color.setOnClickListener(View.OnClickListener {
            if (estudoelementos2_check_fill_color.isChecked) {
                estudoelementos2_img_android.setColorFilter(resources.getColor(R.color.colorAccent))
            } else {
                estudoelementos2_img_android.setColorFilter(resources.getColor(R.color.black))
            }
        })

    }
}