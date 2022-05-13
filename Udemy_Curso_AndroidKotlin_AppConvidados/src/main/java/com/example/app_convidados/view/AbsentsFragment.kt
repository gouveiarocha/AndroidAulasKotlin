package com.example.app_convidados.view

import android.content.Intent
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
import com.example.app_convidados.databinding.FragmentAbsentsBinding
import com.example.app_convidados.service.constants.GuestConstants
import com.example.app_convidados.view.adapter.GuestAdapter
import com.example.app_convidados.view.listener.GuestListener
import com.example.app_convidados.viewmodel.GuestViewModel

class AbsentsFragment : Fragment() {

    private lateinit var mViewModel: GuestViewModel
    private val mAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        mViewModel = ViewModelProvider(this).get(GuestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_absents, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_absents)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(GuestConstants.ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.load(GuestConstants.FILTER.ABSENTS)
            }

        }

        mAdapter.attachListener(mListener)

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load(GuestConstants.FILTER.ABSENTS)
    }

    private fun observer() {
        mViewModel.guestList.observe(this, Observer {
            mAdapter.updateGuests(it)
        })
    }

}