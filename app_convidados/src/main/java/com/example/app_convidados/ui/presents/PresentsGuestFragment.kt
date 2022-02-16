package com.example.app_convidados.ui.presents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.app_convidados.databinding.FragmentPresentsBinding

class PresentsGuestFragment : Fragment() {

    private lateinit var presentsGuestViewModel: PresentsGuestViewModel
    private var _binding: FragmentPresentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presentsGuestViewModel =
            ViewModelProvider(this).get(PresentsGuestViewModel::class.java)

        _binding = FragmentPresentsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        presentsGuestViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}