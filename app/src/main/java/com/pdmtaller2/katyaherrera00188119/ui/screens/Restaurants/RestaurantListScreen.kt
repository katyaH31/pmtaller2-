package com.pdmtaller2.katyaherrera00188119.ui.screens.Restaurants

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.katyaherrera00188119.ui.components.VisualRestaurantCard
import com.pdmtaller2.katyaherrera00188119.ui.layout.CustomTopBar
import com.pdmtaller2.katyaherrera00188119.ui.navigation.SearchScreenNavigation

@Composable
fun RestaurantListScreen(
    navController: NavHostController,
    onRestaurantClick: (Int) -> Unit = {},
    viewModel: RestaurantListViewModel = viewModel()
) {
    val restaurants by viewModel.restaurants.collectAsState()
    val loading by viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        CustomTopBar(
            title = "Restaurantes",
            onSearchClick = {
                navController.navigate(SearchScreenNavigation)
            }
        )

        if (loading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            // Títulos para cada sección
            val sectionTitles = listOf("Populares", "Nuevos", "Recomendados")

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(sectionTitles.size) { sectionIndex ->
                    Text(
                        text = sectionTitles[sectionIndex],
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(4) { cardIndex ->
                            val restaurant = restaurants.getOrNull(cardIndex) ?: return@items

                            VisualRestaurantCard(
                                restaurant = restaurant,
                                onClick = onRestaurantClick
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
