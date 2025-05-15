import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdmtaller2.katyaherrera00188119.ui.components.VisualRestaurantCard
import com.pdmtaller2.katyaherrera00188119.ui.screens.Restaurants.RestaurantListViewModel

@Composable
fun RestaurantListScreen(
    onRestaurantClick: (Int) -> Unit = {},
    viewModel: RestaurantListViewModel = viewModel()
) {
    val restaurants by viewModel.restaurants.collectAsState()
    val loading by viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }

    if (loading) {
        CircularProgressIndicator()
        return
    }

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
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )


            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Mostrar las card
                items(3) { cardIndex ->
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
