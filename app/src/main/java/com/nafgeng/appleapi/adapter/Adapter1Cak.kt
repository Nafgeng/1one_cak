package com.nafgeng.appleapi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nafgeng.appleapi.R
import com.nafgeng.appleapi.databinding.ItemRecycler1cakBinding
import com.nafgeng.appleapi.response.PostsItem

class Adapter1Cak : RecyclerView.Adapter<Adapter1Cak.OneCakViewHolder>() {

    private val listMeme: ArrayList<PostsItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun datameme(ambildata: List<PostsItem>) {
        listMeme.clear()
        listMeme.addAll(ambildata)
        notifyDataSetChanged()
    }

    class OneCakViewHolder(val binding: ItemRecycler1cakBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneCakViewHolder {
        val listItemOneCakBinding =
            ItemRecycler1cakBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OneCakViewHolder(listItemOneCakBinding)
    }

    override fun onBindViewHolder(holder: OneCakViewHolder, position: Int) {
        val data = listMeme[position]
        holder.binding.tvId.text = data.id
        holder.binding.tvTittle.text = data.title
        holder.binding.tvUrl.text = data.url
        Glide.with(holder.binding.ivMeme)
            .load(data.src)
            .into(holder.binding.ivMeme)
    }

    override fun getItemCount(): Int {
        return listMeme.size
    }

}