package com.example.demoprojectmvvm.presentation.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.demoprojectmvvm.R
import com.example.demoprojectmvvm.databinding.ItemPhotoBinding
import com.example.demoprojectmvvm.domain.model.PhotoModel

class PhotoGenericAdapter(
    private var photoList: List<PhotoModel>,
) : RecyclerView.Adapter<PhotoGenericAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PhotoModel) {
            with(binding.image) {
                load(item.url) {
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val photo: PhotoModel = photoList[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int = photoList.size

}