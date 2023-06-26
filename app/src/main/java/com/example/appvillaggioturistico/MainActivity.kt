package com.example.appvillaggioturistico

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.appvillaggioturistico.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonConfirm.setOnClickListener {
            val switchActivityIntent = Intent(
                this,
                HomeActivity::class.java
            )
            startActivity(switchActivityIntent) }

        binding.buttonDecline.setOnClickListener {
            val switchActivityIntent = Intent(
                this,
                GuardianFormActivity::class.java
            )
            startActivity(switchActivityIntent)}
    }
}