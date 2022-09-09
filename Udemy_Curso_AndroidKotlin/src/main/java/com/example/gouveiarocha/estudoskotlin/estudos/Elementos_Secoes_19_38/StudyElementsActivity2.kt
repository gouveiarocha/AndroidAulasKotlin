package com.example.gouveiarocha.estudoskotlin.estudos.Elementos_Secoes_19_38

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gouveiarocha.estudoskotlin.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_study_elements2.*

class StudyElementsActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_elements2)

        btn_toast_test.setOnClickListener(this)
        btn_toast_test_cust.setOnClickListener(this)
        btn_snack_test.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btn_toast_test -> {
                toast("Teste Toast")
            }
            R.id.btn_toast_test_cust -> {
                val toast = Toast.makeText(this, "Teste!!!", Toast.LENGTH_LONG)

                // Pegando o elemento da Toast para modifica-lo.
                //val textView = toast.view?.findViewById<TextView>(android.R.id.message)
                //textView?.setTextColor(Color.RED)

                // Muda a posição da Toast
                toast.setGravity(Gravity.CENTER, 0, 0)

                // Definindo um layout customizado para a Toast
                val layout = layoutInflater.inflate(R.layout.toast_layout, null)
                toast.view = layout

                toast.show()
            }
            R.id.btn_snack_test -> {
                snack("Teste Snack!!!")
            }

        }
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    private fun snack(str: String) {
        // Cria a Snack, observar que obrigatoriamente precisa de um Layout pai. No Caso o linear_root.
        val snack = Snackbar.make(linear_root, str, Snackbar.LENGTH_LONG)
        // Cria ação no Snack.
        snack.setAction("Desfazer", View.OnClickListener {
            toast("Desfeito...")
        })
        // Customiza cores.
        snack.setActionTextColor(Color.BLUE)
        snack.setBackgroundTint(Color.LTGRAY)

        snack.show()
    }

}