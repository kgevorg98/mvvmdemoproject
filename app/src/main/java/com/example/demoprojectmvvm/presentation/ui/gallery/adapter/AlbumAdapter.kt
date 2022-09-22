package com.example.demoprojectmvvm.presentation.ui.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.demoprojectmvvm.databinding.ItemAlbumBinding
import com.example.demoprojectmvvm.domain.model.AlbumModel
import com.example.demoprojectmvvm.domain.model.PhotoModel
import com.example.demoprojectmvvm.presentation.appbase.adapter.BaseAdapter
import com.example.demoprojectmvvm.presentation.appbase.adapter.BaseViewHolder
import com.example.demoprojectmvvm.presentation.utils.show

class AlbumAdapter :
    BaseAdapter<ViewBinding, AlbumModel, BaseViewHolder<AlbumModel, ViewBinding>>() {
    val photos: MutableList<PhotoModel> = mutableListOf()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<AlbumModel, ViewBinding> {
        return ItemViewHolder(
            ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    inner class ItemViewHolder(private val binding: ItemAlbumBinding) :
        BaseViewHolder<AlbumModel, ViewBinding>(binding) {
        override fun bind(item: AlbumModel, context: Context) {
            with(binding) {
                title.text = item.title
                PhotoAdapter().apply {
                    submitList(photos.filter { item.id == it.albumId })
                    photosRv.adapter = this
                    divider.show(adapterPosition != currentList.size-1)
                }
            }
        }
    }
}