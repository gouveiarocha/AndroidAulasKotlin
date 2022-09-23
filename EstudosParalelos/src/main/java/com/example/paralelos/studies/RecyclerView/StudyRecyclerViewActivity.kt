package com.example.paralelos.studies.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paralelos.R
import com.example.paralelos.studies.RecyclerView.model.fakeEmails

/**
 * Estudo Dominando RecyclerView Tiago Aguiar - https://www.youtube.com/watch?v=ASlnPPiZGKE
 */

class StudyRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_study)
        recyclerView.adapter = EmailAdapter(fakeEmails())
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}