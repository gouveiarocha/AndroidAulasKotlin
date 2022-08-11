package com.example.kotlinflowtutorial

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kotlinflowtutorial.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.run {
            setHasFixedSize(true)
            adapter = mainAdapter
        }

        // Primeiro exemplo, usando o collect.
        lifecycleScope.launch {
            viewModel.getLanguages().collect { language ->
                //mainAdapter.addLanguage(language)
            }
        }

        // Segundo exemplo, usando o livedata - aqui não precisamos do escopo de coroutines.
        viewModel.languagesData.observe(this) { language ->
            mainAdapter.addLanguage(language)
        }

    }
}