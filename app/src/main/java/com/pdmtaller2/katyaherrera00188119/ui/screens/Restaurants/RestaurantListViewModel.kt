package com.pdmtaller2.katyaherrera00188119.ui.screens.Restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmtaller2.katyaherrera00188119.data.model.Restaurant
import com.pdmtaller2.katyaherrera00188119.data.repository.restaurant.RestaurantRepository
import com.pdmtaller2.katyaherrera00188119.data.repository.restaurant.RestaurantRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantListViewModel : ViewModel() {
    private val repository: RestaurantRepository = RestaurantRepositoryImpl()

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun loadRestaurants() {
        viewModelScope.launch {
            _loading.value = true
            _restaurants.value = repository.getRestaurants()
            _loading.value = false
        }
    }
}
