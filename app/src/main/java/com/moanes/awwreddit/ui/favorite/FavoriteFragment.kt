package com.moanes.awwreddit.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.moanes.awwreddit.R
import com.moanes.awwreddit.ui.BasePostListFragment
import com.moanes.awwreddit.ui.BasePostListViewModel
import com.moanes.awwreddit.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.postsListRV

@AndroidEntryPoint
class FavoriteFragment : BasePostListFragment() {
    private val mViewModel : FavoriteViewModel by viewModels()

    override val viewModel: BasePostListViewModel
        get() = mViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=postsListRV

        handleClearButton()
    }

    private fun handleClearButton(){
        clearBTN.setOnClickListener {
            mViewModel.clearFavorites()
        }
    }

}