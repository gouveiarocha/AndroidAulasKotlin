package com.example.paralelos.studies.Flow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paralelos.databinding.ItemLanguageBinding

class StudyFlowAdapter : RecyclerView.Adapter<StudyFlowAdapter.StudyFlowViewHolder>() {

    private val languages: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyFlowViewHolder {
        return StudyFlowViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudyFlowViewHolder, position: Int) {
        holder.bind(languages[position])
    }

    override fun getItemCount() = languages.count()

    fun addLanguage(language: String) {
        languages.add(language)
        notifyItemInserted(itemCount)
    }

    class StudyFlowViewHolder(private val binding: ItemLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(language: String) {
            binding.textLanguage.text = language
        }

        companion object {
            fun create(parent: ViewGroup): StudyFlowViewHolder {
                val itemBinding = ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return StudyFlowViewHolder(itemBinding)
            }
        }

    }

}