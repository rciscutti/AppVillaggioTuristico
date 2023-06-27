package com.example.appvillaggioturistico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.view.WindowCompat
import com.example.appvillaggioturistico.databinding.ActivityGuardianFormBinding
import com.example.appvillaggioturistico.databinding.ActivityMainBinding

class GuardianFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuardianFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianFormBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val vociPersonalizzate = listOf("Alice", "Bob", "Charlie", "Dave")

        val spinner = binding.chooseGuardianSpinner

        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            vociPersonalizzate
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        setContentView(R.layout.activity_guardian_form)
    }
}