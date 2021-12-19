package com.moanes.awwreddit.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import com.moanes.awwreddit.R
import com.moanes.awwreddit.ui.BasePostListFragment
import com.moanes.awwreddit.ui.BasePostListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.postsListRV
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class SearchFragment : BasePostListFragment() {
    private val mViewModel: SearchViewModel by viewModels()

    override val viewModel: BasePostListViewModel
        get() = mViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = postsListRV

        handleSearch()
    }

    private fun handleSearch() {
        searchBTN.setOnClickListener {
            search()
        }

        searchInput.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                search()
                return@setOnEditorActionListener true
            }

            return@setOnEditorActionListener false
        }
    }

    private fun search() {
        mViewModel.query = searchInput.text.toString()
        viewModel.getPosts()
    }
}