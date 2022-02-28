package com.example.app_convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_convidados.R
import com.example.app_convidados.databinding.FragmentAllBinding
import com.example.app_convidados.view.adapter.GuestAdapter
import com.example.app_convidados.viewmodel.AllGuestViewModel
import kotlinx.android.synthetic.main.fragment_all.*

/**
 * Atenção, a implementação abaixo veio diretamente do android. Ela possui um novo objeto '_binding' to tipo FragmentAllBinding?
 *  Vou manter essa implementação assim para fins de estudo. Os demais views vou seguir igual o curso.
 */

class AllGuestFragment : Fragment() {

    private lateinit var allGuestViewModel: AllGuestViewModel
    private var _binding: FragmentAllBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        allGuestViewModel = ViewModelProvider(this).get(AllGuestViewModel::class.java)

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // RecyclerView

        // 1 - Obter a recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        // 2 - Definir o layout
        recycler.layoutManager = LinearLayoutManager(context)

        // 3 - Definir um adapter
        recycler.adapter = GuestAdapter()

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}