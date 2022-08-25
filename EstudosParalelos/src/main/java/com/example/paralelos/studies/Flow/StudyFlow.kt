package com.example.paralelos.studies.Flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.paralelos.databinding.ActivityStudyFlowBinding
import kotlinx.coroutines.launch

class StudyFlow : AppCompatActivity() {

    private val viewModel by viewModels<StudyFlowViewModel>()
    private val studyFlowAdapter = StudyFlowAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityStudyFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.run {
            setHasFixedSize(true)
            adapter = studyFlowAdapter
        }

        // Primeiro exemplo, usando o collect.
        lifecycleScope.launch {
            viewModel.getLanguages().collect { language ->
                //mainAdapter.addLanguage(language)
            }
        }

        // Segundo exemplo, usando o livedata - aqui não precisamos do escopo de coroutines.
        viewModel.languagesData.observe(this) { language ->
            studyFlowAdapter.addLanguage(language)
        }

    }
}