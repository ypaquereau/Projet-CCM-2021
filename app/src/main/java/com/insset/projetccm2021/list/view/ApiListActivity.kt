package com.insset.projetccm2021.list.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.insset.projetccm2021.databinding.ActivityApiListBinding

class ApiListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApiListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}