package com.zubairqazi.coffeetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    val EXTRA_MESSAGE = "com.zubairqazi.coffeetracker.MESSAGE"

    private val buttonLogin: Button by lazy {
        findViewById<Button>(R.id.buttonLogin)
    }

    private val buttonRegister: Button by lazy {
        findViewById<Button>(R.id.buttonRegister)
    }

    private lateinit var db: FirebaseFirestore

    lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()

        buttonRegister.setOnClickListener {
            message = buttonRegister.text.toString()
            val registerIntent = Intent(this, SignupActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(registerIntent)
        }

        buttonLogin.setOnClickListener {
            message = buttonLogin.text.toString()
            val loginIntent = Intent(this, LoginActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(loginIntent)
        }

    }

}
