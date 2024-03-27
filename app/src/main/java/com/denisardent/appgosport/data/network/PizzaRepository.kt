package com.denisardent.appgosport.data.network

import com.denisardent.appgosport.entites.PizzaData

interface PizzaRepository {
    suspend fun getPizzaList(): List<PizzaData>
}