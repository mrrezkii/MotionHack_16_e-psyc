package com.motionlaboratory.e_psyc.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.motionlaboratory.e_psyc.databinding.FragmentOrderBinding
import com.motionlaboratory.e_psyc.source.model.Chat
import com.motionlaboratory.e_psyc.source.model.mockChat

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = ChatAdapter(mockChat(), object : ChatAdapter.OnAdapterListener {
            override fun onClick(result: Chat) {

            }

        })
        binding.listChat.adapter = adapter
    }

}