package com.motionlaboratory.e_psyc.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motionlaboratory.e_psyc.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private val binding: ActivityAuthBinding by lazy { ActivityAuthBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}