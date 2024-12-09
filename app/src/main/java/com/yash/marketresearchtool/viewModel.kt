package com.yash.marketresearchtool

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.RestrictTo
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import java.time.Duration
import java.util.Collections

class viewModel:ViewModel() {
    val messagelist = Collections.synchronizedList(mutableListOf<String>())
    val generativeModel:GenerativeModel= GenerativeModel(
        modelName = "gemini-1.5-pro",
        apiKey = constant.apikey
    )
   suspend fun sendMessage(company:String):MutableList<String>{
       val prompt="Tell me about ${company} and a few product it manufacture  , Also specify 7 use cases for that company based on products it manufacture"
       val response = generativeModel.generateContent(prompt)
       Log.d("D", response.text.toString())
       messagelist.add(response.text.toString())
       Log.d("D", messagelist.toString())
       return messagelist
    }
}