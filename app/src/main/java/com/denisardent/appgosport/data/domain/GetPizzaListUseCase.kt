package com.denisardent.appgosport.data.domain

import com.denisardent.appgosport.entites.PizzaData
import com.denisardent.appgosport.data.network.PizzaRepository
import javax.inject.Inject

class GetPizzaListUseCase @Inject constructor(
    private val pizzaRepository: PizzaRepository
) {
    suspend operator fun invoke(): List<PizzaData>{
        return pizzaRepository.getPizzaList()
    }
}