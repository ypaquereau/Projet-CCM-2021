package com.insset.projetccm2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.insset.projetccm2021.auth.view.LoginActivity
import com.insset.projetccm2021.databinding.ActivityMainBinding
import com.insset.projetccm2021.list.view.ApiListActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()

        val buttonToApi: Button = binding.buttonToApi
        val buttonToAuth: Button = binding.buttonToAuth

        buttonToApi.setOnClickListener() {
            val intent = Intent(this, ApiListActivity::class.java)
            startActivity(intent)
        }

        val currentFirebaseUser: FirebaseUser? = auth.currentUser

        if (currentFirebaseUser !== null) {
            buttonToAuth.text = getString(R.string.buttonLogout)

            val userIdField: TextView = binding.userId
            userIdField.text = currentFirebaseUser.uid

            buttonToAuth.setOnClickListener() {
                auth.signOut()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        } else {
            buttonToAuth.setOnClickListener() {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}