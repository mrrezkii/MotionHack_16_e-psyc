package com.motionlaboratory.e_psyc.ui.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.motionlaboratory.e_psyc.databinding.AdapterTicketBinding
import com.motionlaboratory.e_psyc.source.model.Ticket

class TicketAdapter(
    var tickets: ArrayList<Ticket>,
    val listerner: OnAdapterListener
) : RecyclerView.Adapter<TicketAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterTicketBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener {
        fun onClick(result: Ticket)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: TicketAdapter.ViewHolder, position: Int) {
        val ticket = tickets[position]
        holder.binding.tvName.text = ticket.name
        holder.binding.tvSchedule.text = ticket.schedule
        holder.binding.tvDate.text = ticket.date

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(10))

        Glide
            .with(holder.binding.ivAvatarDoctor.context)
            .load(ticket.photo)
            .apply(requestOptions)
            .into(holder.binding.ivAvatarDoctor)

        holder.binding.container.setOnClickListener {
            listerner.onClick(ticket)
        }
    }

    override fun getItemCount() = tickets.size

    fun setData(data: List<Ticket>) {
        tickets.clear()
        tickets.addAll(data)
        notifyDataSetChanged()
    }

}
