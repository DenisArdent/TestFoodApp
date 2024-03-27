package com.denisardent.appgosport.data.network

import com.denisardent.appgosport.entites.PizzaData
import retrofit2.http.GET

interface PizzaApi {

    @GET("pizzas")
    suspend fun getPizzaList(): List<PizzaData>
}