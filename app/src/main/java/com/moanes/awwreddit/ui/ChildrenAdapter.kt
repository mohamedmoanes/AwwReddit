package com.moanes.awwreddit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.moanes.awwreddit.R
import com.moanes.awwreddit.utils.setImageURL
import com.moanes.datasource.model.Children

class ChildrenAdapter(
    private val handleFavorite: (item: Children) -> Unit,
    private val favoriteIdsList: List<String>
) :
    ListAdapter<Children, ChildrenAdapter.ViewHolder>(ChildrenItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.favoriteBTN.isActivated = favoriteIdsList.contains(item.post.id)

        holder.title.text = item.post.title
        if (!item.post.thumbnail.isNullOrBlank())
            holder.image.setImageURL(item.post.thumbnail)
        holder.playIcon.visibility = if (item.post.secureMedia != null) View.VISIBLE
        else
            View.GONE
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: MaterialTextView = view.findViewById(R.id.title)
        val image: ShapeableImageView = view.findViewById(R.id.image)
        val playIcon: ShapeableImageView = view.findViewById(R.id.playIcon)
        val favoriteBTN: AppCompatImageButton = view.findViewById(R.id.favBTN)
    }

    class ChildrenItemDiffCallback : DiffUtil.ItemCallback<Children>() {
        override fun areItemsTheSame(oldItem: Children, newItem: Children): Boolean {
            return oldItem.post.id == newItem.post.id
        }

        override fun areContentsTheSame(oldItem: Children, newItem: Children): Boolean {
            return oldItem.equals(newItem)
        }
    }
}