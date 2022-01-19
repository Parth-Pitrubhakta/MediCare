package com.example.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_page.*

private const val TAG = "LoginPage"
class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            goHomePage()
            finish()

        }

        button_login.setOnClickListener {
            button_login.isEnabled = false
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            if (email.isBlank() || password.isBlank()) {
                button_login.isEnabled = true
                Toast.makeText(this, "Email and password cannot be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    button_login.isEnabled = true
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    goHomePage()
                } else {
                    button_login.isEnabled = true
                    Log.i(TAG, "signInWithEmail failed", task.exception)
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        button_signUp.setOnClickListener{
            goSignipPage()
        }
    }

    private fun goSignipPage() {
        startActivity(Intent(this, SignupPage::class.java))
        finish()
    }

    private fun goHomePage() {
         startActivity(Intent(this, HomePage::class.java))
         finish()
    }
}