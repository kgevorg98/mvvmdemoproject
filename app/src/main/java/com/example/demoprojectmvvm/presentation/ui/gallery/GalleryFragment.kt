package com.example.demoprojectmvvm.presentation.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoprojectmvvm.R
import com.example.demoprojectmvvm.databinding.FragmentGalleryBinding
import com.example.demoprojectmvvm.presentation.ui.gallery.adapter.AlbumAdapter
import com.example.demoprojectmvvm.presentation.utils.observeInLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GalleryViewModel by viewModel()
    private val albumAdapter = AlbumAdapter()

    private fun onEach() {
        onEach(viewModel.getAlbums) {
            it?.let { albums ->
                albumAdapter.submitList(albums)
            }
        }

        onEach(viewModel.getPhotos) {
            it?.let { photos ->
                albumAdapter.photos.addAll(photos)
            }
        }
    }

    private inline fun <reified T> onEach(flow: Flow<T>, crossinline action: (T) -> Unit) =
        view?.run {
            if (!this@GalleryFragment.isAdded) return@run
            flow.onEach { action(it ?: return@onEach) }.observeInLifecycle(viewLifecycleOwner)
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
        onEach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initRecycler() {
        with(binding) {
            albums.run {
                context?.let { context ->
                    adapter = albumAdapter
                    layoutManager =
                        LinearLayoutManager(
                            context,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        
                }
            }
        }
    }
}