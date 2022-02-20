package com.motionlaboratory.e_psyc.ui.counseling

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motionlaboratory.e_psyc.databinding.ActivityCounselingBinding
import com.motionlaboratory.e_psyc.source.model.Doctor
import com.motionlaboratory.e_psyc.source.model.mockDoctor
import com.motionlaboratory.e_psyc.ui.main.DoctorAdapter
import com.motionlaboratory.e_psyc.ui.pay.PayActivity
import timber.log.Timber

class CounselingActivity : AppCompatActivity() {

    private val binding: ActivityCounselingBinding by lazy {
        ActivityCounselingBinding.inflate(
            layoutInflater
        )
    }

    private lateinit var adapter: DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupRecyclerView()
    }

    private fun setupView() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        adapter = DoctorAdapter(mockDoctor(), object : DoctorAdapter.OnAdapterListener {
            override fun onClick(result: Doctor) {
                Timber.e("$result")
                val intent = Intent(this@CounselingActivity, PayActivity::class.java)
                intent.putExtra("doctor", result)
                startActivity(intent)
            }

        })
        binding.listDoctor.adapter = adapter
    }
}