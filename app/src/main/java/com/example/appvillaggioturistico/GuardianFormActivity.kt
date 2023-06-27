package com.example.appvillaggioturistico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.WindowCompat
import com.example.appvillaggioturistico.databinding.ActivityGuardianFormBinding
import com.example.appvillaggioturistico.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.Arrays

class GuardianFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuardianFormBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var dbRef: DatabaseReference
    private var guardiani: Array<String> = arrayOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianFormBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        database = FirebaseDatabase.getInstance()
        dbRef = database.getReference("/guardiano")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                caricaGuardiani(dataSnapshot)

                val spinner = binding.chooseGuardianSpinner
                val adapter = ArrayAdapter<String>(
                    this@GuardianFormActivity,
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

            override fun onCancelled(databaseError: DatabaseError) {
                // Gestisci eventuali errori di recupero dati
            }
        })

        binding.inviaFormButton.setOnClickListener {
            val switchActivityIntent = Intent(
                this,
                HomeActivity::class.java
            )

            val bundle = bundleOf("nome_guardiano" to binding.chooseGuardianSpinner.selectedItem)

            switchActivityIntent.putExtras(bundle)
            startActivity(switchActivityIntent)
        }

    }

    private fun caricaGuardiani (dataSnapshot: DataSnapshot) {
        var nome: String
        var cognome: String


        for (guardiano: DataSnapshot in dataSnapshot.children) {

            nome = guardiano.child("nome").getValue(String::class.java).toString()
            cognome = guardiano.child("cognome").getValue(String::class.java).toString()
            guardiani = guardiani.plus("$nome $cognome")

            Log.i("firebase", "GUARDIANI:  ${guardiani.contentToString()}")


            Log.i("firebase", "Nome: $nome $cognome")

        }
    }

}