package com.example.demoprojectmvvm.presentation.ui.gallery.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import coil.load
import com.example.demoprojectmvvm.R
import com.example.demoprojectmvvm.databinding.ItemPhotoBinding
import com.example.demoprojectmvvm.domain.model.PhotoModel
import com.example.demoprojectmvvm.presentation.appbase.adapter.BaseAdapter
import com.example.demoprojectmvvm.presentation.appbase.adapter.BaseViewHolder

class PhotoAdapter : BaseAdapter<ViewBinding, PhotoModel, BaseViewHolder<PhotoModel, ViewBinding>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<PhotoModel, ViewBinding> {
        return ItemViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ItemViewHolder(private val binding:ItemPhotoBinding):BaseViewHolder<PhotoModel, ViewBinding>(binding){
        override fun bind(item: PhotoModel, context: Context) {
            itemView.context?.let {
                binding.image.load(item.url){
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                }
            }

        }

    }

}