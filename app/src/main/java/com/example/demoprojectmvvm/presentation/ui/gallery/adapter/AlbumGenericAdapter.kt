package com.example.demoprojectmvvm.presentation.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bekawestberg.loopinglayout.library.LoopingLayoutManager
import com.example.demoprojectmvvm.databinding.ItemAlbumBinding
import com.example.demoprojectmvvm.domain.model.AlbumModel
import com.example.demoprojectmvvm.domain.model.PhotoModel
import com.example.demoprojectmvvm.presentation.utils.show

class AlbumGenericAdapter(
    private val albums: List<AlbumModel>,
    private val photos: List<PhotoModel>
) : RecyclerView.Adapter<AlbumGenericAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AlbumModel) {
            with(binding) {
                title.text = item.title
                val photoList = photos.filter { item.id == it.albumId }
                val photoAdapter = PhotoGenericAdapter(photoList)
                divider.show(adapterPosition != photoList.size - 1)
                photosRv.apply {
                    setHasFixedSize(true)
                    layoutManager = LoopingLayoutManager(context, LoopingLayoutManager.HORIZONTAL)
                    adapter = photoAdapter
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val album: AlbumModel = albums[position]
        holder.bind(album)
    }

    override fun getItemCount(): Int {
        return albums.size
    }


}