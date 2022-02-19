package com.motionlaboratory.e_psyc.ui.pay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motionlaboratory.e_psyc.databinding.ActivityPayBinding
import com.motionlaboratory.e_psyc.source.model.Doctor

class PayActivity : AppCompatActivity() {

    private val doctor by lazy { intent.getParcelableExtra<Doctor>("doctor") }

    private val binding: ActivityPayBinding by lazy {
        ActivityPayBinding.inflate(
            layoutInflater
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.tvName.text = doctor!!.name
        binding.tvPrice.text = doctor!!.price
        binding.tvTotal.text = doctor!!.price
        binding.tvTotalBills.text = doctor!!.price
    }

}