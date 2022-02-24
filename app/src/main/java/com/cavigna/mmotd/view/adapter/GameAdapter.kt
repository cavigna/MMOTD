package com.cavigna.mmotd.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cavigna.mmotd.R
import com.cavigna.mmotd.databinding.ItemRowBinding
import com.cavigna.mmotd.model.models.Game
import com.cavigna.mmotd.utils.parseDateGame


class GameAdapter( val extraerDatos : ExtraerDatos) : ListAdapter<Game, MyViewHolder>(ComparadorGame()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val game = getItem(position)
        with(holder.binding){
            imageViewRow.load(game.thumbnail)
            textViewTitleRefactor.text = game.title
            //textViewReleaseRow.text = parseDateGame(game.releaseDate)
            textViewGenreRow.text = game.genre


            cardView.setOnClickListener {
                extraerDatos.sacarId(game.id)
                Navigation.findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_detailsFragment)
            }
        }
    }



    interface ExtraerDatos {
        fun sacarId(id:Int)
    }

}
class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val binding: ItemRowBinding = ItemRowBinding.bind(itemView)

    companion object{
        fun create(parent: ViewGroup):MyViewHolder{
            val layoutInflaterB = LayoutInflater.from(parent.context)
            val binding = ItemRowBinding.inflate(layoutInflaterB, parent, false)

            return MyViewHolder(binding.root)
        }
    }

}
class ComparadorGame : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.id == newItem.id
    }

}
