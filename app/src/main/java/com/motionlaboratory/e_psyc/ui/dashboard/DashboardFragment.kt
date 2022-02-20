package com.motionlaboratory.e_psyc.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.motionlaboratory.e_psyc.databinding.FragmentDashboardBinding
import com.motionlaboratory.e_psyc.source.model.Doctor
import com.motionlaboratory.e_psyc.source.model.mockDoctor
import com.motionlaboratory.e_psyc.ui.article.ArticleActivity
import com.motionlaboratory.e_psyc.ui.counseling.CounselingActivity
import com.motionlaboratory.e_psyc.ui.main.DoctorAdapter
import com.motionlaboratory.e_psyc.ui.main.MainViewModel
import com.motionlaboratory.e_psyc.ui.pay.PayActivity
import com.motionlaboratory.e_psyc.utils.observe
import com.motionlaboratory.e_psyc.utils.showToast
import timber.log.Timber

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }
    private lateinit var adapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDoctor()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupView()
    }

    private fun setupObserver() {
        observe(viewModel.doctors) {
            Timber.e("$it")
            //adapter.setData(it)
        }
        observe(viewModel.message) { message ->
            showToast(message)
        }
    }

    private fun setupRecyclerView() {
        adapter = DoctorAdapter(mockDoctor(), object : DoctorAdapter.OnAdapterListener {
            override fun onClick(result: Doctor) {
                Timber.e("$result")
                val intent = Intent(requireActivity(), PayActivity::class.java)
                intent.putExtra("doctor", result)
                startActivity(intent)
            }

        })
        binding.listDoctor.adapter = adapter
    }

    private fun setupView() {
        binding.ivCounseling.setOnClickListener {
            startActivity(Intent(requireActivity(), CounselingActivity::class.java))
        }
        binding.tvCounseling.setOnClickListener {
            startActivity(Intent(requireActivity(), CounselingActivity::class.java))
        }
        binding.ivArticle.setOnClickListener {
            startActivity(Intent(requireActivity(), ArticleActivity::class.java))
        }
        binding.tvArticle.setOnClickListener {
            startActivity(Intent(requireActivity(), ArticleActivity::class.java))
        }
    }

}