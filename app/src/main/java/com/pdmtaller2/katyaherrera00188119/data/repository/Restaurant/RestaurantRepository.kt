package com.pdmtaller2.katyaherrera00188119.data.repository.restaurant

import com.pdmtaller2.katyaherrera00188119.data.model.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
}
