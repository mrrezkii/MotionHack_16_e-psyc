package com.motionlaboratory.e_psyc.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.motionlaboratory.e_psyc.databinding.AdapterDoctorBinding
import com.motionlaboratory.e_psyc.source.model.Doctor

class DoctorAdapter(
    var doctors: ArrayList<Doctor>,
    val listerner: OnAdapterListener
) : RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterDoctorBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener {
        fun onClick(result: Doctor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterDoctorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DoctorAdapter.ViewHolder, position: Int) {
        val doctor = doctors[position]
        holder.binding.tvName.text = doctor.name
        holder.binding.tvDay.text = doctor.schedule
        holder.binding.tvRate.text = doctor.rate
        holder.binding.tvPrice.text = doctor.price
        holder.binding.container.setOnClickListener {
            listerner.onClick(doctor)
        }
    }

    override fun getItemCount() = doctors.size

    fun setData(data: List<Doctor>) {
        doctors.clear()
        doctors.addAll(data)
        notifyDataSetChanged()
    }

}
