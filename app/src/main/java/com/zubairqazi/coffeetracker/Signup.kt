package com.zubairqazi.coffeetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class Signup : AppCompatActivity() {

    val TAG = "MainActivity"
    val EXTRA_MESSAGE = "com.zubairqazi.coffeetracker.MESSAGE"

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val firstName: String = findViewById<TextView>(R.id.firstName).text.toString()
        val lastName: String = findViewById<TextView>(R.id.lastName).text.toString()
        val yearBorn: String = findViewById<TextView>(R.id.yearBorn).text.toString()

        val user = hashMapOf(
            "first" to firstName,
            "last" to lastName,
            "born" to yearBorn
        )

        val sendUser = findViewById<Button>(R.id.sendUser)
        sendUser.setOnClickListener {
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, "Returning to home")
            }
            startActivity(intent)
        }

    }

    fun onClickBtn(view: View) {
        Toast.makeText(this, "This is the second screen!!", Toast.LENGTH_LONG).show()
    }
}
