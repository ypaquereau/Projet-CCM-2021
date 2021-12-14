package com.insset.projetccm2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.insset.projetccm2021.auth.view.LoginActivity
import com.insset.projetccm2021.list.view.ApiListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToApi: Button = findViewById(R.id.buttonToApi)
        val buttonToAuth: Button = findViewById(R.id.buttonToAuth)

        buttonToApi.setOnClickListener() {
            val intent = Intent(this, ApiListActivity::class.java)
            startActivity(intent)
        }

        buttonToAuth.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}