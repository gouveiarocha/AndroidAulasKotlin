package com.example.paralelos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.paralelos.R
import com.example.paralelos.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Navegação usando o Navigation Component - (finNavControler)
        binding.tvTestClick.setOnClickListener {

            // Primeira forma e mais simples ->
            //Observar que O ID referenciado no navigate, foi criado no mobile_navigation ao
            //criarmos o action - é possivel cria-lo através do xml ou da interface de design.
            //t.findNavController().navigate(R.id.action_nav_home_to_nav_test)

            // Agora usando os recursos do plugin de navegação safeargs
            val direction = HomeFragmentDirections.actionNavHomeToNavTest(50)
            it.findNavController().navigate(direction)

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}