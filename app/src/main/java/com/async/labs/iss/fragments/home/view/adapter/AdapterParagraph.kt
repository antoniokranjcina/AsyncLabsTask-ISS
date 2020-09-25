package com.async.labs.iss.fragments.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.async.labs.iss.R
import com.async.labs.iss.fragments.home.service.model.Paragraphs
import kotlinx.android.synthetic.main.item_paragraph.view.*

class AdapterParagraph :
    ListAdapter<Paragraphs, AdapterParagraph.ViewHolder>(ParagraphsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_paragraph, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.paragraph.text = currentList[position].paragraph
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val paragraph: TextView = itemView.description_paragraph
    }
}

class ParagraphsDiffCallback : DiffUtil.ItemCallback<Paragraphs>() {
    override fun areItemsTheSame(oldItem: Paragraphs, newItem: Paragraphs): Boolean {
        return oldItem.paragraph == newItem.paragraph
    }

    override fun areContentsTheSame(oldItem: Paragraphs, newItem: Paragraphs): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}