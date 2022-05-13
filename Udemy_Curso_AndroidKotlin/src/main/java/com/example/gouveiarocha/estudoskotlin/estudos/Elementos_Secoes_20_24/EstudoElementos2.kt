package com.example.gouveiarocha.estudoskotlin.estudos.Elementos_Secoes_20_24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gouveiarocha.estudoskotlin.R
import kotlinx.android.synthetic.main.estudo_act_elementos2.*

/**
 * imageview, checkbox
 */

class EstudoElementos2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estudo_act_elementos2)

        estudoelementos2_check_fill_color.setOnClickListener(View.OnClickListener {
            if(estudoelementos2_check_fill_color.isChecked){
                estudoelementos2_img_android.setColorFilter(resources.getColor(R.color.colorAccent))
            }else{
                estudoelementos2_img_android.setColorFilter(resources.getColor(R.color.black))
            }
        })

    }
}