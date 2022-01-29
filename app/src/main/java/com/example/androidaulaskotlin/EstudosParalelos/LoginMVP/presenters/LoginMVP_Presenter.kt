package com.example.loginmvp.presenters

import com.example.loginmvp.interfaces.LoginMVP_LoginContract
import com.example.loginmvp.utils.LoginMVP_AuthUtils
import com.example.loginmvp.utils.LoginMVP_Constants

class LoginMVP_Presenter(private val view: LoginMVP_LoginContract.View) : LoginMVP_LoginContract.Presenter {

    /**
     * No Presenter podemos definir um método comum a todas as camadas
     * Aqui podemos fazer o Bind das views necessárias na Activity
     * ou qualquer outra inicialização necessária
     */
    override fun start() {
        view.bindViews()
    }

    /**
     * Principal lógica responsável pelo login e senha do nosso aplicativo
     * Simplificando a separação de camadas do software.
     */
    override fun isLoginValid(login: String, password: String) {
        if (login.isEmpty() || password.isEmpty()) {
            if (login.isEmpty()) {
                view.showErrorMessage(LoginMVP_Constants.LOGIN_TYPE_ERROR.EMPTY_LOGIN)
            } else {
                view.showErrorMessage(LoginMVP_Constants.LOGIN_TYPE_ERROR.EMPTY_PASSWORD)
            }
        } else {
            if (login == LoginMVP_AuthUtils.USERNAME && password == LoginMVP_AuthUtils.PASSWORD) {
                view.showSuccessMessage()
                view.startHomeActivity()
            } else {
                if (login != LoginMVP_AuthUtils.USERNAME) {
                    view.showErrorMessage(LoginMVP_Constants.LOGIN_TYPE_ERROR.INCORRECT_LOGIN)
                } else {
                    view.showErrorMessage(LoginMVP_Constants.LOGIN_TYPE_ERROR.INCORRECT_PASSWORD)
                }
            }
        }
    }

}