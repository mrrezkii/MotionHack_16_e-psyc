package com.motionlaboratory.e_psyc.ui.pay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motionlaboratory.e_psyc.databinding.ActivityStatusBinding
import com.motionlaboratory.e_psyc.source.model.Doctor
import com.motionlaboratory.e_psyc.ui.main.MainActivity

class StatusActivity : AppCompatActivity() {

    private val doctor by lazy { intent.getParcelableExtra<Doctor>("doctor") }

    private val binding: ActivityStatusBinding by lazy {
        ActivityStatusBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.tvName.text = doctor!!.name
        binding.flHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}