package com.example.app_convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_convidados.R
import com.example.app_convidados.databinding.FragmentAllBinding
import com.example.app_convidados.service.constants.GuestConstants
import com.example.app_convidados.view.adapter.GuestAdapter
import com.example.app_convidados.view.listener.GuestListener
import com.example.app_convidados.viewmodel.GuestViewModel

/**
 * Atenção, a implementação abaixo veio diretamente do android. Ela possui um novo objeto '_binding' to tipo FragmentAllBinding?
 * Vou manter essa implementação assim para fins de estudo. Os demais views vou seguir igual o curso.
 */

class AllGuestFragment : Fragment() {

    private lateinit var mViewModel: GuestViewModel
    private var _binding: FragmentAllBinding? = null

    private val mAdapter = GuestAdapter()

    private lateinit var mListener: GuestListener

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        mViewModel = ViewModelProvider(this).get(GuestViewModel::class.java)

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // RecyclerView

        // 1 - Obter a recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        // 2 - Definir o layout
        recycler.layoutManager = LinearLayoutManager(context)

        // 3 - Definir um adapter
        recycler.adapter = mAdapter

        mListener = object : GuestListener{
            override fun onClick(id: Int) {
                //sobescreve o metodo de onClick que criamos na interface
                //vamos abrir GuestFormActivity passando os dados do convidado para edição.
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(GuestConstants.ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.load(GuestConstants.FILTER.ALL)
            }

        }

        mAdapter.attachListener(mListener)

        observer()

        return root

    }

    override fun onResume() {
        super.onResume()
        mViewModel.load(GuestConstants.FILTER.ALL)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        mViewModel.guestList.observe(this, Observer {
            mAdapter.updateGuests(it)
        })
    }

}