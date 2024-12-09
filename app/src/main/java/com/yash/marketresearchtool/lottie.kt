package com.yash.marketresearchtool

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class lottie : AppCompatActivity() {
    var Handler=Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lottie)
        Handler.postDelayed(Runnable { startActivity(Intent(this@lottie,MainActivity::class.java))
        finish()},5000)
    }
}