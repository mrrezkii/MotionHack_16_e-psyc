package com.motionlaboratory.e_psyc.ui.webinar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motionlaboratory.e_psyc.databinding.ActivityWebinarBinding

class WebinarActivity : AppCompatActivity() {

    private val binding: ActivityWebinarBinding by lazy {
        ActivityWebinarBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun setupView() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}