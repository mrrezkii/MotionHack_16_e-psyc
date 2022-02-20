package com.motionlaboratory.e_psyc.ui.webinar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.motionlaboratory.e_psyc.databinding.ActivityDetailWebinarBinding
import com.motionlaboratory.e_psyc.source.model.Ticket

class DetailWebinarActivity : AppCompatActivity() {

    private val binding: ActivityDetailWebinarBinding by lazy {
        ActivityDetailWebinarBinding.inflate(
            layoutInflater
        )
    }

    private val data by lazy { intent.getParcelableExtra<Ticket>("data") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.ivBack.setOnClickListener {
            finish()
        }

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(10))

        Glide
            .with(binding.ivBanner.context)
            .load(data!!.photo)
            .apply(requestOptions)
            .into(binding.ivBanner)

        binding.tvName.text = data!!.name
        binding.tvDate.text = "${data!!.date}\n${data!!.schedule}"
    }

}