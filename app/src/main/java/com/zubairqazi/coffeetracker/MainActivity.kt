package com.zubairqazi.coffeetracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    val EXTRA_MESSAGE = "com.zubairqazi.coffeetracker.MESSAGE"

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val users = db.collection("Users")

        val user = hashMapOf(
            "id" to "00000001",
            "first" to "Alan",
            "middle" to "Mathison",
            "last" to "Turing",
            "born" to 1912
        )

        val mSendData = findViewById<Button>(R.id.sendData)

        mSendData.setOnClickListener {
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }

        val mReadData = findViewById<Button>(R.id.readData)

        mReadData.setOnClickListener {
            db.collection("users")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }
        }

        val mSignUp = findViewById<Button>(R.id.signUp)

        mSignUp.setOnClickListener {
            val message = mSignUp.text.toString()
            val intent = Intent(this, SignupActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }

    }

}
