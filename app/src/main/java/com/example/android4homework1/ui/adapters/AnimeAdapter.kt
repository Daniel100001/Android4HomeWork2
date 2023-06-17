package com.example.android4homework1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android4homework1.ProgressTarget
import com.example.android4homework1.models.rickAndMortyCharacter.MangaModel
import com.example.rickandmorty.databinding.ItemKitsuBinding

class AnimeAdapter() :
    PagingDataAdapter<MangaModel, AnimeAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(mangaModel: MangaModel) {
            binding.itemCharacterName.text = mangaModel.attributes.titles.nameInJapanese
            val progressTarget = ProgressTarget(binding.progressBar, binding.itemCharacterImage)
            Glide.with(binding.itemCharacterImage).load(mangaModel.attributes.posterImage.original)
                .into(binding.itemCharacterImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemKitsuBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<MangaModel>() {

        override fun areItemsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
            return oldItem == newItem
        }
    }
}