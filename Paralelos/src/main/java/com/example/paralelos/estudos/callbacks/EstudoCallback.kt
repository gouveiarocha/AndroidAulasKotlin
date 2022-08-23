package com.example.paralelos.estudos.callbacks

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.paralelos.R

class EstudoCallback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudo_callback)

        someFunction(object : SomeCallback {
            override fun onSuccess() {
                Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(error: String) {
                Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun someFunction(someCallback: SomeCallback) {
        val word = "Douglas"
        val letter = "n"
        if (word.contains(letter)) {
            someCallback.onSuccess()
        } else {
            someCallback.onFailure("$word does not contain $letter")
        }
    }

}

interface SomeCallback {
    fun onSuccess()
    fun onFailure(error: String)
}