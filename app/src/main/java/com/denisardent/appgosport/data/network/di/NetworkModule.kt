package com.denisardent.appgosport.data.network.di

import com.denisardent.appgosport.data.network.PizzaApi
import com.denisardent.appgosport.data.network.PizzaNetworkRepository
import com.denisardent.appgosport.data.network.PizzaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDishesApi(retrofit: Retrofit): PizzaApi {
        return retrofit.create(PizzaApi::class.java)
    }

    @Provides
    fun providesDishesRepository(pizzaApi: PizzaApi): PizzaRepository
            = PizzaNetworkRepository(pizzaApi, Dispatchers.IO)
}

const val BASE_URL = "https://6601d3719d7276a755523acc.mockapi.io/api/v1/"