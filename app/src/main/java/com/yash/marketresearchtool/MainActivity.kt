package com.yash.marketresearchtool

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.yash.marketresearchtool.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import java.time.Duration
import java.util.Collections

class MainActivity : AppCompatActivity() {
    var response:String=""
    val viewmoddel=viewModel()
    var messagelist= mutableListOf<String>()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.result.movementMethod = ScrollingMovementMethod()
        binding.generate.setOnClickListener {
            val company = binding.company.text
            lifecycleScope.launch {
                messagelist=viewmoddel.sendMessage(company.toString())
                var size=messagelist.size
                Log.d("D",size.toString())
                binding.result.text=messagelist.get(size-1)
            }

        }

    }
}