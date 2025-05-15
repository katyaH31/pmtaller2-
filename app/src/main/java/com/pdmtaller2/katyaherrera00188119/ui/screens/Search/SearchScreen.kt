package com.pdmtaller2.katyaherrera00188119.ui.screens.Search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.katyaherrera00188119.ui.components.VisualRestaurantCard
import com.pdmtaller2.katyaherrera00188119.ui.navigation.MenuScreenNavigation
import com.pdmtaller2.katyaherrera00188119.ui.screens.Restaurants.RestaurantListViewModel



@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel: RestaurantListViewModel = viewModel()
    val allRestaurants by viewModel.restaurants.collectAsState()
    var query by remember { mutableStateOf("") }

    val filteredRestaurants = allRestaurants.filter {
        it.name.contains(query, ignoreCase = true)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar restaurante") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (filteredRestaurants.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No se encontraron restaurantes")
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(filteredRestaurants) { restaurant ->
                    VisualRestaurantCard(
                        restaurant = restaurant,
                        onClick = {
                            navController.navigate(MenuScreenNavigation(it))
                        }
                    )
                }
            }
        }
    }
}
