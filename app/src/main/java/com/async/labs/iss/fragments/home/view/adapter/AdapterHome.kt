package com.async.labs.iss.fragments.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.async.labs.iss.R
import com.async.labs.iss.fragments.home.service.model.HomeWikipediaItems
import kotlinx.android.synthetic.main.item_wiki_home.view.*

class AdapterHome(private val listener: OnItemClickListener) :
    ListAdapter<HomeWikipediaItems, AdapterHome.ViewHolder>(HomeItemAboutDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_wiki_home, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = currentList[position].title
        holder.description.text = currentList[position].description
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val title: TextView = itemView.title
        val description: TextView = itemView.description

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(currentList[adapterPosition])
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(homeWikipediaItems: HomeWikipediaItems)
    }
}

class HomeItemAboutDiffCallback : DiffUtil.ItemCallback<HomeWikipediaItems>() {
    override fun areItemsTheSame(
        oldItem: HomeWikipediaItems,
        newItem: HomeWikipediaItems
    ): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.description == newItem.description &&
                oldItem.youtubeLink == newItem.youtubeLink
    }

    override fun areContentsTheSame(
        oldItem: HomeWikipediaItems,
        newItem: HomeWikipediaItems
    ): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}