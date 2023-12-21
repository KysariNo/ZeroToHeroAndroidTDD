package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel (


    private  val liveDataWrapper :LiveDataWrapper,
    private val repository : Repository
):ProvideLiveData {

    private val viewModelScope = CoroutineScope(SupervisorJob()+ Dispatchers.Main.immediate)


    fun load(){


        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowDate)
        }
    }

    override fun liveData()  =liveDataWrapper.liveData()

}