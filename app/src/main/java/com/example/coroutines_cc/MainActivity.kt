package com.example.coroutines_cc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var btnBackgroundThread : Button
    private lateinit var btnMainThread : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnMainThread = findViewById(R.id.btnMainThread)
        btnBackgroundThread = findViewById(R.id.btnBackgroundThread)

        btnMainThread.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch { // Adding a coroutine to execute the task
                Log.i("MyTag", "Main Thread ${Thread.currentThread().name}")
            }
        }

        btnBackgroundThread.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch { // Adding a coroutine to execute the task
                Log.i("MyTag", "Background Thread ${Thread.currentThread().name}")
            }
        }
    }
}