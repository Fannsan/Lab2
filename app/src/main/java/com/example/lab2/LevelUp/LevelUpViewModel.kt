package com.example.lab2.LevelUp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LevelUpViewModel: ViewModel() {

    //Setup mutableStateFlow
   private val _uiState = MutableStateFlow(LevelUpUiState())
    val uiState: StateFlow<LevelUpUiState> = _uiState.asStateFlow()


    fun setExcitedQuote() {
        _uiState.update {
                state -> state.copy(
                    myList = arrayListOf(getRandomExcitedQuote())
                )
        }
    }

    fun setTiredQuote(){
        _uiState.update {
            state -> state.copy(
            myList = arrayListOf(getRandomTiredQuote())
            )
        }
    }

    fun setAnxiousQuote(){
        _uiState.update {
            state -> state.copy(
            myList = arrayListOf(getRandomAnxiousQuote())
            )
        }
    }

    fun setIrritatedQuote(){
        _uiState.update {
            state -> state.copy(
            myList = arrayListOf(getRandomIrritatedQuote())
            )
        }
    }


    fun getRandomExcitedQuote():String{

        return uiState.value.excitedList.random()

    }

    fun getRandomTiredQuote(): String {
        return uiState.value.tiredList.random()
    }

    fun getRandomAnxiousQuote(): String{
        return uiState.value.tiredList.random()
    }

    fun getRandomIrritatedQuote(): String {

        return uiState.value.irritatedList.random()
    }



}