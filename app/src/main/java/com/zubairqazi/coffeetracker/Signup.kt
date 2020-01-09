package com.zubairqazi.coffeetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Signup : AppCompatActivity() {

    val TAG = "SignupActivity"
    val EXTRA_MESSAGE = "com.zubairqazi.coffeetracker.MESSAGE"

    lateinit var editUserEmail: EditText
    lateinit var editUserPwd: EditText

    val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editUserEmail = findViewById(R.id.emailField)
        editUserPwd = findViewById(R.id.pwdField)

        val btnRegister = findViewById<Button>(R.id.buttonRegister)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        btnRegister.setOnClickListener {
            registerUser()
        }

        btnLogin.setOnClickListener {

        }

        auth = FirebaseAuth.getInstance()
    }

    private fun registerUser() {
        val userEmail: String? = editUserEmail.text.toString()
        val userPwd: String? = editUserPwd.text.toString()

        if (userEmail.isNullOrBlank()) {
            TODO("Email field check not yet implemented.")
        }
        if (userPwd.isNullOrBlank()) {
            TODO("Password field check not yet implemented.")
        }


    }

}
