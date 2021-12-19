package com.moanes.awwreddit.ui

import android.app.ProgressDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.moanes.datasource.model.Post

abstract class BasePostListFragment:Fragment() {
    abstract val viewModel:BasePostListViewModel
    private lateinit var adapter:PostAdapter
    lateinit var recyclerView: RecyclerView
    private lateinit var progressDialog: ProgressDialog
    override fun onResume() {
        super.onResume()
        progressDialog = ProgressDialog(requireContext())

        handleLoading()
        handleError()

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
        adapter = PostAdapter(::handleFavorite, viewModel.favoriteIds!!)
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

    private fun handleLoading() {
        viewModel.loadingObservable.subscribe {
            if (it)
                progressDialog.show()
            else
                progressDialog.hide()
        }
    }

    private fun handleError(){
        viewModel.errorObservable.subscribe {
            view?.let { it1 -> Snackbar.make(it1, it, Snackbar.LENGTH_SHORT).show() }
        }
    }
}