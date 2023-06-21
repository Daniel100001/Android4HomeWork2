package com.example.android4homework2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android4homework2.data.models.MangaModel
import com.example.rickandmorty.databinding.ItemKitsuBinding

class MangaAdapter(private val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<MangaModel, MangaAdapter.MangaViewHolder>(DiffUtilCallback()) {

    inner class MangaViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(absoluteAdapterPosition)
            }
        }

        fun onBind(mangaModel: MangaModel?) {
            binding.itemCharacterName.text = mangaModel?.attributes?.title?.nameInJapanese
            Glide.with(binding.itemCharacterImage).load(mangaModel?.attributes?.posterImage?.original)
                .into(binding.itemCharacterImage)
        }
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            ItemKitsuBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<MangaModel>() {

            override fun areItemsTheSame(
                oldItem: MangaModel,
                newItem: MangaModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MangaModel,
                newItem: MangaModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

