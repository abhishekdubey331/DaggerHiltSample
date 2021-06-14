package com.abhishek.daggerhilt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abhishek.daggerhilt.databinding.ActivityMainBinding
import com.abhishek.daggerhilt.models.Car
import com.abhishek.daggerhilt.models.Engine
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var car: Car
    @Inject
    lateinit var engine: Engine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hiltTextView.apply {
            text = engine.startEngine().plus("\n"+car.runCar())
        }
    }
}