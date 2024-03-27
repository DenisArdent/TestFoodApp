package com.denisardent.appgosport.data.network

import com.denisardent.appgosport.entites.PizzaData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PizzaNetworkRepository @Inject constructor(
    private val pizzaApi: PizzaApi,
    private val dispatcher: CoroutineDispatcher
): PizzaRepository {
    override suspend fun getPizzaList(): List<PizzaData> =
        withContext(dispatcher){
            pizzaApi.getPizzaList()
        }
}