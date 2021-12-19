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
import com.moanes.datasource.model.Post

class PostAdapter(
    private val handleFavorite: (item: Post, remove: Boolean) -> Unit,
    private val favoriteIdsList: MutableList<String>
) :
    ListAdapter<Post, PostAdapter.ViewHolder>(PostItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(holder.bindingAdapterPosition)
        holder.favoriteBTN.isActivated = favoriteIdsList.contains(item.id)

        holder.title.text = item.title
        if (!item.thumbnail.isNullOrBlank())
            holder.image.setImageURL(item.thumbnail)
        holder.playIcon.visibility = if (item.isVideo != null && item.isVideo) View.VISIBLE
        else
            View.GONE

        holder.favoriteBTN.setOnClickListener {
            handleFavorite(item, holder.favoriteBTN.isActivated)
            if (favoriteIdsList.contains(item.id))
                favoriteIdsList.remove(item.id)
            else
                favoriteIdsList.add(item.id)
            notifyItemChanged(holder.bindingAdapterPosition)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: MaterialTextView = view.findViewById(R.id.title)
        val image: ShapeableImageView = view.findViewById(R.id.image)
        val playIcon: ShapeableImageView = view.findViewById(R.id.playIcon)
        val favoriteBTN: AppCompatImageButton = view.findViewById(R.id.favBTN)
    }

    class PostItemDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.equals(newItem)
        }
    }
}