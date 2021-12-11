package com.insset.projetccm2021.list.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.insset.projetccm2021.databinding.ActivityApiListBinding
import com.insset.projetccm2021.list.model.MovieShowQuoteUi
import com.insset.projetccm2021.list.viewmodel.MovieShowViewModel

class ApiListActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieShowViewModel
    private lateinit var binding: ActivityApiListBinding
    private val adapter: ApiListAdapter = ApiListAdapter()
    private val observer = Observer<List<MovieShowQuoteUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MovieShowViewModel::class.java]

        binding.ApiListActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.ApiListActivityRv.adapter = adapter

        binding.ApiListActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }

        binding.ApiListActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.movieShowQuoteLiveData.observe(this, observer)
    }

    override fun onStop() {
        viewModel.movieShowQuoteLiveData.removeObserver(observer)
        super.onStop()
    }

}