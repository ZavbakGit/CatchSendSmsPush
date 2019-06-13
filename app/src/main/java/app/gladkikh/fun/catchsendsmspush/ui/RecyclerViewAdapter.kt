package app.gladkikh.`fun`.catchsendsmspush.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import app.gladkikh.`fun`.catchsendsmspush.R

import app.gladkikh.`fun`.catchsendsmspush.intity.SmsMessage
import java.util.*


class RecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    var items: List<SmsMessage> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).
            inflate(R.layout.rv_item_message, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)
        private val tvMessage = itemView.findViewById<TextView>(R.id.tvMessage)
        private val tvDate = itemView.findViewById<TextView>(R.id.tvDate)

        fun bind(smsMessage: SmsMessage) {
            tvPhone.text = smsMessage.phoneSender
            tvMessage.text = smsMessage.message
            tvDate.text = android.text.format.
                DateFormat.format("yyyy-MM-dd hh:mm:ss a", Date(smsMessage.date))
        }
    }
}

