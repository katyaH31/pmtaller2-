package com.pdmtaller2.katyaherrera00188119.data.repository.restaurant

import com.pdmtaller2.katyaherrera00188119.data.dummy.restaurants
import com.pdmtaller2.katyaherrera00188119.data.model.Restaurant
import kotlinx.coroutines.delay

class RestaurantRepositoryImpl : RestaurantRepository {

    override suspend fun getRestaurants(): List<Restaurant> {
        delay(2000) // Simulando llamada
        return restaurants
    }
}
