package com.example.androidaulaskotlin.EstudosParalelos.LoginMVP.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidaulaskotlin.R
import com.example.loginmvp.interfaces.LoginMVP_LoginContract
import com.example.loginmvp.presenters.LoginMVP_Presenter

class LoginMVP_LoginActivity : AppCompatActivity(), LoginMVP_LoginContract.View {

    override lateinit var presenter: LoginMVP_Presenter

    lateinit var mUserLogin: EditText
    lateinit var mUserPassword: EditText
    lateinit var mLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginmvp_act_login)

        //Bind do Presenter com a nossa View
        presenter = LoginMVP_Presenter(this)

        //Chama o método responsável por dizer a View o que deve ser inicializado.
        presenter.start()

        mLoginButton.setOnClickListener(){
            //Comunica e Transfere a responsabilidade do Login para o Presenter
            //Que então irá validar se o Login é válido ou não.
            presenter.isLoginValid(mUserLogin.text.toString(), mUserPassword.text.toString())
        }


    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showSuccessMessage() {
        Toast.makeText(this, "Login Efetuado com Sucesso", Toast.LENGTH_SHORT).show()
    }

    override fun startHomeActivity() {
        startActivity(Intent(this, LoginMVP_HomeActvity::class.java))
    }

    override fun bindViews() {
        mUserLogin = findViewById(R.id.edt_login)
        mUserPassword = findViewById(R.id.edt_password)
        mLoginButton = findViewById(R.id.btn_login)
    }
}