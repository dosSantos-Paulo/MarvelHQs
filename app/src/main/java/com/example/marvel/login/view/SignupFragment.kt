package com.example.marvel.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.marvel.R
import com.google.android.material.textfield.TextInputLayout


class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val arrowButton = view.findViewById<ImageView>(R.id.arrowBack_signup)
        val saveButton = view.findViewById<Button>(R.id.btn_save_signup)

        val name = view.findViewById<TextInputLayout>(R.id.editText_name_signup).editText
        val email = view.findViewById<TextInputLayout>(R.id.editText_email_signup).editText
        val password = view.findViewById<TextInputLayout>(R.id.editText_password_signup).editText

        saveButton.setOnClickListener {
            nullValidation(name, email, password)

            if (!name?.text?.trim().isNullOrEmpty() &&
                !email?.text?.trim().isNullOrEmpty() &&
                !password?.text?.trim().isNullOrEmpty()){
                Toast.makeText(view.context, "clicou --> ${saveButton.text}", Toast.LENGTH_SHORT).show()
            }
        }

        arrowButton.setOnClickListener {
            navController.popBackStack()
        }
    }

    private fun nullValidation(
        name: EditText?,
        email: EditText?,
        password: EditText?
    ) {
        if (name?.text?.trim().isNullOrEmpty()) {
            name?.error = getString(R.string.need_a_name)
        }

        if (email?.text?.trim().isNullOrEmpty()) {
            email?.error = getString(R.string.need_an_email)
        }

        if (password?.text?.trim().isNullOrEmpty()) {
            password?.error = getString(R.string.need_a_password)
        }
    }

}