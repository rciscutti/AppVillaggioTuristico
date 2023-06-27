package com.example.appvillaggioturistico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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

        val guardiani = arrayOf("", "Alice", "Bob", "Charlie", "Dave")

        val spinner = binding.chooseGuardianSpinner

        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            guardiani
        )

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0) {
                    Toast.makeText(
                        applicationContext,
                        "Il guardiano selezionato è ${guardiani[position]}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }
}