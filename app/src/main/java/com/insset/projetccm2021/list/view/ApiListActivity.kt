package com.insset.projetccm2021.list.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.insset.projetccm2021.databinding.ActivityApiListBinding
import com.insset.projetccm2021.list.model.Header
import com.insset.projetccm2021.list.model.MyObjectForRecyclerView
import com.insset.projetccm2021.list.viewmodel.MovieShowViewModel
import java.text.SimpleDateFormat
import java.util.*

class ApiListActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieShowViewModel
    private lateinit var binding: ActivityApiListBinding
    private val adapter: ApiListAdapter = ApiListAdapter()
    private val observer = Observer<List<MyObjectForRecyclerView>> {
        update(it)
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

    private fun update(base: List<MyObjectForRecyclerView>) {
        val result = mutableListOf<MyObjectForRecyclerView>()
        val data = mutableListOf<MyObjectForRecyclerView>()

        data.addAll(base)

        data.groupBy {
            SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE).format(Date(it.timestamp)).toString()
        }.forEach { (timestamp, items) ->
            result.add(Header("Date : $timestamp"))
            result.addAll(items)
        }

        adapter.submitList(result)
    }
}