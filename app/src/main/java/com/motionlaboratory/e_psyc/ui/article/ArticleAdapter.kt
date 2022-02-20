package com.motionlaboratory.e_psyc.ui.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.motionlaboratory.e_psyc.databinding.AdapterArticleBinding
import com.motionlaboratory.e_psyc.source.model.Article

class ArticleAdapter(
    var articles: ArrayList<Article>,
    val listerner: OnAdapterListener
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterArticleBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener {
        fun onClick(result: Article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ArticleAdapter.ViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.tvName.text = article.title
    }

    override fun getItemCount() = articles.size

    fun setData(data: List<Article>) {
        articles.clear()
        articles.addAll(data)
        notifyDataSetChanged()
    }

}
