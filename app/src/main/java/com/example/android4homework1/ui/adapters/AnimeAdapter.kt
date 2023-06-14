package com.example.android4homework1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android4homework1.models.rickAndMortyCharacter.AnimeModel
import com.example.rickandmorty.databinding.ItemKitsuBinding

class AnimeAdapter(private val onItemClick: (id: String) -> Unit) :
    ListAdapter<AnimeModel, AnimeAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(position.toString())
            }
        }

        fun onBind(animeModel: AnimeModel) {
            binding.itemCharacterName.text = animeModel.attributes.titles.nameInJapanese
            Glide.with(binding.itemCharacterImage).load(animeModel.attributes.posterImage.original)
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
        holder.onBind(getItem(position))
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<AnimeModel>() {

        override fun areItemsTheSame(oldItem: AnimeModel, newItem: AnimeModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AnimeModel, newItem: AnimeModel): Boolean {
            return oldItem == newItem
        }
    }
}