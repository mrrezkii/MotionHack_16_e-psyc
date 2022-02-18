package com.motionlaboratory.e_psyc.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motionlaboratory.e_psyc.databinding.ActivitySplashScreenBinding
import com.motionlaboratory.e_psyc.ui.auth.AuthActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(
            layoutInflater
        )
    }
    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        delayMain()
    }

    private fun delayMain() {
        activityScope.launch {
            delay(4000)
            startActivity(Intent(this@SplashScreenActivity, AuthActivity::class.java))
            finish()
        }
    }
}