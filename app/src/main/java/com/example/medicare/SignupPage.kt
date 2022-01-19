package com.example.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_signup_page.*

class SignupPage : AppCompatActivity() {
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        button_gologinpage.setOnClickListener{
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }

        signup_button_submit.setOnClickListener {
            signup_button_submit.isEnabled = false
            val username = signup_username.text.toString()
            val email = signup_email.text.toString()
            val password = signup_password.text.toString()
            val repassword = signup_repassword.text.toString()

            if (username.isBlank() || email.isBlank() || password.isBlank() || repassword.isBlank()){
                signup_button_submit.isEnabled = true
                Toast.makeText(this, "Any field cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {task->
                if (task.isSuccessful){
                    signup_button_submit.isEnabled = true
                    Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                    gologinactivity()
                }else{
                    signup_button_submit.isEnabled = true
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun gologinactivity() {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginPage::class.java))
        finish()
    }
}