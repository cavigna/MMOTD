package com.cavigna.mmotd.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cavigna.mmotd.databinding.ImageRowBinding
import com.cavigna.mmotd.model.models.details.Screenshot

class ScreenShotAdapter : ListAdapter<Screenshot, ImageHolder>(ComparadorImage()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val screenshot = getItem(position)

        holder.binding.imageView.load(screenshot.image)
    }
}

class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: ImageRowBinding = ImageRowBinding.bind(itemView)

    companion object {
        fun create(parent: ViewGroup): ImageHolder {
            val layoutInflaterB = LayoutInflater.from(parent.context)
            val binding = ImageRowBinding.inflate(layoutInflaterB, parent, false)

            return ImageHolder(binding.root)
        }
    }


}

class ComparadorImage : DiffUtil.ItemCallback<Screenshot>() {
    override fun areItemsTheSame(oldItem: Screenshot, newItem: Screenshot): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: Screenshot, newItem: Screenshot): Boolean {
        return oldItem.id == newItem.id
    }
}



