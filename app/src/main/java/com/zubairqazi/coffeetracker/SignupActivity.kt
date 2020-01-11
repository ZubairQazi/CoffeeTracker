package com.zubairqazi.coffeetracker

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignupActivity : AppCompatActivity() {

    val TAG = "SignupActivity"
    val EXTRA_MESSAGE = "com.zubairqazi.coffeetracker.MESSAGE"

    private lateinit var editUserEmail: EditText
    private lateinit var editUserPwd: EditText

    private lateinit var btnRegister: Button

    private lateinit var signUpText: TextView

    val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editUserEmail = findViewById(R.id.emailField)
        editUserPwd = findViewById(R.id.pwdField)

        btnRegister = findViewById(R.id.buttonRegister)

        signUpText = findViewById(R.id.textViewSignIn)

        btnRegister.setOnClickListener {
            registerUser()
        }

        signUpText.setOnClickListener {
            // Open login page
        }

        auth = FirebaseAuth.getInstance()
    }

    private fun registerUser() {
        val userEmail: String? = editUserEmail.text.toString()
        val userPwd: String? = editUserPwd.text.toString()

        if (userEmail.isNullOrBlank()) {
            Toast.makeText(this, "Please enter an email.", Toast.LENGTH_SHORT).show()
            // Add a toast message
            return
        }
        if (userPwd.isNullOrBlank()) {
            Toast.makeText(this, "Please enter a password.", Toast.LENGTH_SHORT).show()
            // Add a toast message
            return
        }

        auth.createUserWithEmailAndPassword(userEmail, userPwd)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    Toast.makeText(baseContext, "Registered successfully!",
                        Toast.LENGTH_SHORT).show()
//                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

            }

    }

}
