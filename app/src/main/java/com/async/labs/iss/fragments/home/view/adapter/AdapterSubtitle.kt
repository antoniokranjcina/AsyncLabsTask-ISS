package com.async.labs.iss.fragments.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.async.labs.iss.R
import com.async.labs.iss.fragments.home.service.model.Subtitle
import kotlinx.android.synthetic.main.subtitle_item.view.*

class AdapterSubtitle :
    ListAdapter<Subtitle, AdapterSubtitle.ViewHolder>(SubtitleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.subtitle_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val adapterParagraph = AdapterParagraph()
        adapterParagraph.submitList(currentList[position].paragraphs)

        holder.title.text = currentList[position].title
        holder.recyclerViewParagraphs.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterParagraph
            setHasFixedSize(true)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.title_subtitle
        val recyclerViewParagraphs: RecyclerView = itemView.recycler_view
    }
}

class SubtitleDiffCallback : DiffUtil.ItemCallback<Subtitle>() {
    override fun areItemsTheSame(oldItem: Subtitle, newItem: Subtitle): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.paragraphs == newItem.paragraphs
    }

    override fun areContentsTheSame(oldItem: Subtitle, newItem: Subtitle): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}