package com.tp.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tp.newsletter.R
import com.tp.newsletter.model.Article
import com.tp.newsletter.model.Category

class ArticleAdapter (private val dataset: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtTitle = root.findViewById<TextView>(R.id.article_title)
            val imageView = root.findViewById<ImageView>(R.id.article_image)
            val articleSource = root.findViewById<TextView>(R.id.article_source)
            val articleDesc = root.findViewById<TextView>(R.id.article_description)
            //val txtDesc = root.findViewById<TextView>(R.id.article_description)
            txtTitle.text = item.title
            articleSource.text = item.source.name
            articleDesc.text = item.description
            //txtDesc.text = item.description
            Glide
                    .with(root)
                    .load(item.urlToImage)
                    .fitCenter()
                    .placeholder(R.drawable.placeholder)
                    .into(imageView);

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(dataset[position])
    }
}