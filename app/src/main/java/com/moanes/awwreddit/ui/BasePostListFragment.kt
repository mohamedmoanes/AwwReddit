package com.moanes.awwreddit.ui

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moanes.datasource.model.Children
import com.moanes.datasource.model.Post

abstract class BasePostListFragment:Fragment() {
    abstract val viewModel:BasePostListViewModel
    private lateinit var adapter:PostAdapter
    lateinit var recyclerView: RecyclerView

    override fun onResume() {
        super.onResume()
        handlePostsObserver()
        initPostsList()
        handlePagination()

        viewModel.getPosts()
    }

    private fun handlePostsObserver() {
        viewModel.postsObservable.subscribe {
            adapter.submitList(it.toMutableList())

        }
    }

    private fun initPostsList() {
        adapter = PostAdapter(::handleFavorite, viewModel.favoriteIds)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun handleFavorite(item: Post, remove: Boolean) {
        viewModel.handleFavorite(item, remove)
    }

    private fun handlePagination() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = recyclerView.layoutManager!!.childCount
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                val firstVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()

                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0
                ) {
                    viewModel.loadNextPage()
                }
            }
        })
    }
}