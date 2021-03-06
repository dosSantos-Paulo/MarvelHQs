package com.example.marvel.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.marvel.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val name = view.findViewById<TextInputLayout>(R.id.editText_email_Login).editText
        val password = view.findViewById<TextInputLayout>(R.id.editText_password_Login).editText
        val remeberCheckBox = view.findViewById<CheckBox>(R.id.checkbox_remember_login)
        val loginButton = view.findViewById<MaterialButton>(R.id.btn_login_login)
        val creatButton = view.findViewById<MaterialButton>(R.id.btn_createAccount_login)

        loginButton.setOnClickListener {

            nullValidation(name, password)

            if (!name?.text?.trim().isNullOrEmpty() && !password?.text?.trim().isNullOrEmpty()){
                navController.navigate(R.id.action_loginFragment_to_mainFragment)
            }

        }

        creatButton.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

    private fun nullValidation(name: EditText?, password: EditText?) {
        if (name?.text?.trim().isNullOrEmpty()) {
            name?.error = getString(R.string.need_a_name)
        }

        if (password?.text?.trim().isNullOrEmpty()) {
            password?.error = getString(R.string.need_a_password)
        }
    }

}