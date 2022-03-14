package com.example.app_convidados.view.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_convidados.R
import com.example.app_convidados.service.model.GuestModel
import com.example.app_convidados.view.listener.GuestListener

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList: List<GuestModel> = arrayListOf()
    private lateinit var mListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    fun updateGuests(list: List<GuestModel>) {
        mGuestList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: GuestListener) {
        mListener = listener
    }

}

class GuestViewHolder(itemView: View, private val listener: GuestListener) :
    RecyclerView.ViewHolder(itemView) {
    fun bind(guest: GuestModel) {

        //nome
        val guestName = itemView.findViewById<TextView>(R.id.guest_name)
        guestName.text = guest.name

        //presença
        val guestPresence = itemView.findViewById<CheckBox>(R.id.guest_presence)
        guestPresence.isChecked = guest.presence

        //evento de click no item da lista.
        guestName.setOnClickListener {
            listener.onClick(guest.id) //método da interface GuestListener que criamos para disparar os eventos de click.
        }

        //evento de click longo no item da lista
        guestName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNeutralButton(R.string.cancelar, null).show()
            true
        }

    }
}

