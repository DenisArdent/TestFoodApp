package com.denisardent.appgosport.presentation.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denisardent.appgosport.data.domain.GetPizzaListUseCase
import com.denisardent.appgosport.entites.PizzaData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel  @Inject constructor(
    private val getPizzaListUseCase: GetPizzaListUseCase
): ViewModel() {
    private val _pizzaList = MutableLiveData<List<PizzaData>>(emptyList())
    val pizzaList: LiveData<List<PizzaData>> = _pizzaList

    private val _buttonsList = MutableLiveData<List<Pair<String, Boolean>>>(
        mutableListOf(Pair("Пицца", true), Pair("Комбо", false),  Pair("Десерты", false), Pair("Напитки", false))
    )
    val buttonsList: LiveData<List<Pair<String, Boolean>>> = _buttonsList

    init {
        viewModelScope.launch {
            _pizzaList.value = getPizzaListUseCase()
        }
    }
}