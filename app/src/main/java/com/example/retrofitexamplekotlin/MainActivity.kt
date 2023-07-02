package com.example.retrofitexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.retrofitexamplekotlin.viewmodal.ViewModal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ViewModal by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getData()
       viewModel.mainResponse.observe(this) {
           Log.d("data response :","$it")

       }
    }
}