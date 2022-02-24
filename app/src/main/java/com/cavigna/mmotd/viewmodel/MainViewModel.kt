package com.cavigna.mmotd.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cavigna.mmotd.model.Repositorio
import com.cavigna.mmotd.model.models.Game
import com.cavigna.mmotd.model.models.GameDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: Repositorio
) : ViewModel() {

    val listadoGames = MutableLiveData<List<Game>>()
    val gameDetail = MutableLiveData<GameDetail>()

    init {
        selectOrFetchGames()
        selectOrFetchGameDetail(452)
    }

    fun selectOrFetchGames() {
        viewModelScope.launch(IO) {
            repo.selectOrFetchGames().collect {
                listadoGames.postValue(it)
            }
        }
    }

    fun selectOrFetchGameDetail(id:Int){
        viewModelScope.launch(IO) {
            repo.selectOrFetchGameDetail(id).collect {
                gameDetail.postValue(it)
            }
        }
    }
}