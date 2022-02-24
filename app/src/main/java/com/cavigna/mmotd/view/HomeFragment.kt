package com.cavigna.mmotd.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cavigna.mmotd.databinding.FragmentHomeBinding
import com.cavigna.mmotd.view.adapter.GameAdapter
import com.cavigna.mmotd.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), GameAdapter.ExtraerDatos {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recycler: RecyclerView
    private val adapter by lazy { GameAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        recycler = binding.recyclerView
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        viewModel.listadoGames.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })


        return binding.root
    }

    override fun sacarId(id: Int) {
        viewModel.selectOrFetchGameDetail(id)
    }


}