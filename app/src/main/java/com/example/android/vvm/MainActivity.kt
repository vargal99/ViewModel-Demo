package com.example.android.vvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    var count = 0
    private lateinit var viewModel: MainACtivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainACtivityViewModel::class.java)
        val message = findViewById<TextView>(R.id.tvCount)
        val btnChange = findViewById<Button>(R.id.bntCount)

       // message.text = count.toString()
       // message.text = viewModel.count.toString()

        viewModel.count.observe(this, Observer{
            message.text = it.toString()
        })

        btnChange.setOnClickListener {
          //  count++
            //message.text = count.toString()
            viewModel.updateCount()
           //  message.text = viewModel.count.toString()

        }
    }
}