package com.example.medicare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.os.Handler
import android.os.Looper


class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}