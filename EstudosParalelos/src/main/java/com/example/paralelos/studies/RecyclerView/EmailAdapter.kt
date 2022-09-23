package com.example.paralelos.studies.RecyclerView

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.paralelos.R
import com.example.paralelos.studies.RecyclerView.model.Email

class EmailAdapter(val emails: MutableList<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailCardViewHolder>() {

    inner class EmailCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_icon = itemView.findViewById<View>(R.id.study_recycler_txt_icon) as TextView
        var txt_user = itemView.findViewById<View>(R.id.study_recycler_txt_user) as TextView
        var txt_subject = itemView.findViewById<View>(R.id.study_recycler_txt_subject) as TextView
        var txt_preview = itemView.findViewById<View>(R.id.study_recycler_txt_preview) as TextView
        var txt_date = itemView.findViewById<View>(R.id.study_recycler_txt_date) as TextView
        var img_stared = itemView.findViewById<View>(R.id.study_recycler_img_star) as ImageView

        fun bind(email: Email) {
            with(email) {

                val hash = user.hashCode()
                txt_icon.text = user.first().toString()
                txt_icon.background = itemView.oval(Color.rgb(hash, hash / 2, 0))

                txt_user.text = user
                txt_user.setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)

                txt_subject.text = subject
                txt_subject.setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)

                txt_preview.text = preview

                txt_date.text = data
                txt_date.setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)

                img_stared.setImageResource(
                    if (stared) R.drawable.ic_star_24
                    else R.drawable.ic_star_border_24
                )

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_study_email_item, parent, false)
        return EmailCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: EmailCardViewHolder, position: Int) {
        holder.bind(emails[position])
    }

}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval) {
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}