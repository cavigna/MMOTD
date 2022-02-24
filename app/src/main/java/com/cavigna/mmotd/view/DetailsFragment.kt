package com.cavigna.mmotd.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cavigna.mmotd.R
import com.cavigna.mmotd.databinding.FragmentDetailsBinding
import com.cavigna.mmotd.utils.parseDateGame
import com.cavigna.mmotd.utils.parseHtml
import com.cavigna.mmotd.utils.sendEmailIntent
import com.cavigna.mmotd.view.adapter.ScreenShotAdapter
import com.cavigna.mmotd.viewmodel.MainViewModel

class DetailsFragment : Fragment() {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var recycler: RecyclerView
    private val adapter by lazy { ScreenShotAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        recycler = binding.recylcerDetails
        recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)


        recycler.adapter = adapter

        viewModel.gameDetail.observe(viewLifecycleOwner,{ game->
            binding.apply {
                imageViewDetails.load(game.thumbnail)
                textViewDescriptionDetails.text = parseHtml(game.description)
                textViewGenreDetails.text = game.genre
                textViewReleaseDetails.text = parseDateGame(game.releaseDate)
                textViewTitleDetails.text =  game.title
                floatingActionButton.setOnClickListener{
                    sendEmailIntent(game, requireContext())
                }
            }
            adapter.submitList(game.screenshots)
            Log.v("prueba", game.screenshots.toString())
        })


        return binding.root
    }


}