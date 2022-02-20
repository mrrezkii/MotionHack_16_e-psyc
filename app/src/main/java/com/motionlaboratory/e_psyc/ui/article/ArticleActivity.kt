package com.motionlaboratory.e_psyc.ui.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motionlaboratory.e_psyc.databinding.ActivityArticleBinding
import com.motionlaboratory.e_psyc.source.model.Article
import com.motionlaboratory.e_psyc.source.model.mockArticle

class ArticleActivity : AppCompatActivity() {

    private val binding: ActivityArticleBinding by lazy {
        ActivityArticleBinding.inflate(
            layoutInflater
        )
    }
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        setupView()
    }

    private fun setupView() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        adapter = ArticleAdapter(mockArticle(), object : ArticleAdapter.OnAdapterListener {
            override fun onClick(result: Article) {

            }

        })
        binding.listArticle.adapter = adapter
    }
}