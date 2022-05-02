package com.example.gouveiarocha.estudoskotlin.Curso_UdemyKotlin2022.apps.GastoViagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gouveiarocha.estudoskotlin.R
import com.example.gouveiarocha.estudoskotlin.databinding.AppgastoviagemActBinding
import kotlinx.android.synthetic.main.appgastoviagem_act.*
import java.lang.NumberFormatException

class AppGastoViagem : AppCompatActivity(), View.OnClickListener {

    //Estudo sobre ViewBinding, foi adicionado no curso. Aula 122.
    private lateinit var binding: AppgastoviagemActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appgastoviagem_act)

        binding = AppgastoviagemActBinding.inflate(layoutInflater)
        binding.editDistance.setText("55") //aqui, já temos acesso ao elemento, utilizando o ViewBinding.

        button_calculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validation()) {
            try {

                val distance = edit_distance.text.toString().toFloat()
                val price = edit_price.text.toString().toFloat()
                val autonomy = edit_autonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                text_result.text = "R$ ${"%.2f".format(totalValue)}"

            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    getString(R.string.preenche_valores_validos),
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_campos), Toast.LENGTH_SHORT).show()
        }

    }

    private fun validation(): Boolean {
        return (edit_autonomy.text.toString() != ""
                && edit_price.text.toString() != ""
                && edit_autonomy.text.toString() != "")

    }

}