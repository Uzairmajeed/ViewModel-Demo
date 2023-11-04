package com.facebook.viewmodel_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.facebook.viewmodel_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = MainViewModel(this)

        // Observe LiveData properties
        viewModel.ids.observe(this, { ids ->
            binding.textId.text = ids.toString()
        })

        viewModel.descriptions.observe(this, { descriptions ->
            binding.textDescription.text = descriptions
        })

        viewModel.titles.observe(this, { titles ->
            binding.textTitle.text = titles
        })

        viewModel.fetchData()
    }
}
