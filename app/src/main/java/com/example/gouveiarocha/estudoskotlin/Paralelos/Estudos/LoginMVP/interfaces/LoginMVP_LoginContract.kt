package com.example.loginmvp.interfaces

import com.example.loginmvp.presenters.LoginMVP_Presenter

/**
 * No contrato podemos definir todos os métodos que são mandatórios
 * de implementação pelas camadas View e Presenter de cada uma de nossas
 * Activities ou Fragments
 */
interface LoginMVP_LoginContract {

    /**
     * Nossa LoginActivity ou nossa View precisa implementar os seguintes métodos
     */
    interface View : LoginMVP_BaseView<LoginMVP_Presenter> {
        fun showErrorMessage(message: String)
        fun showSuccessMessage()
        fun startHomeActivity()
    }

    /**
     * Nosso Presenter precisa implementar os seguintes métodos
     */
    interface Presenter : LoginMVP_BasePresenter {
        fun isLoginValid(login: String, password: String)
    }


}