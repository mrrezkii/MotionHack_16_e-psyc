package com.motionlaboratory.e_psyc.ui.order

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.motionlaboratory.e_psyc.databinding.AdapterChatBinding
import com.motionlaboratory.e_psyc.source.model.Chat

class ChatAdapter(
    var chats: ArrayList<Chat>,
    val listerner: OnAdapterListener
) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterChatBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener {
        fun onClick(result: Chat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        val ticket = chats[position]
        holder.binding.tvName.text = ticket.doctor.name
        holder.binding.tvChat.text = ticket.lastMsg

        holder.binding.container.setOnClickListener {
            listerner.onClick(ticket)
        }
    }

    override fun getItemCount() = chats.size

    fun setData(data: List<Chat>) {
        chats.clear()
        chats.addAll(data)
        notifyDataSetChanged()
    }

}
