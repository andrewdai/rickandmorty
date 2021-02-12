package com.daerawind.rickandmorty.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daerawind.rickandmorty.api.CharRepo
import com.daerawind.rickandmorty.api.Result
import com.daerawind.rickandmorty.model.CharacterSheet
import kotlinx.coroutines.launch

class CharViewModel(private val charRepo: CharRepo): ViewModel() {

    private val _charLiveData = MutableLiveData<CharacterSheet>()
    val charLiveData: LiveData<CharacterSheet> get() = _charLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun getCharacters() = viewModelScope.launch {
        when (val result = charRepo.getCharacters()) {
            is Result.Success -> {
                _charLiveData.postValue(result.data)
            }
            is Result.Failure -> {
                _errorLiveData.postValue("Error: ${result.code} | ${result.message}")
            }
        }
    }
}