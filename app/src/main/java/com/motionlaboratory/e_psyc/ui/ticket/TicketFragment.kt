package com.motionlaboratory.e_psyc.ui.ticket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.motionlaboratory.e_psyc.databinding.FragmentTicketBinding
import com.motionlaboratory.e_psyc.source.model.Ticket
import com.motionlaboratory.e_psyc.source.model.mockTicket
import com.motionlaboratory.e_psyc.ui.webinar.DetailWebinarActivity

class TicketFragment : Fragment() {

    private lateinit var binding: FragmentTicketBinding
    private lateinit var adapter: TicketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = TicketAdapter(mockTicket(), object : TicketAdapter.OnAdapterListener {
            override fun onClick(result: Ticket) {
                val intent = Intent(requireActivity(), DetailWebinarActivity::class.java)
                intent.putExtra("data", result)
                startActivity(intent)
            }

        })
        binding.listTicket.adapter = adapter
    }
}