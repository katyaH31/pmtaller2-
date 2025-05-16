package com.pdmtaller2.katyaherrera00188119.ui.navigation

import MenuScreen
import MyOrdersScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdmtaller2.katyaherrera00188119.ui.screens.Restaurants.RestaurantListScreen
import com.pdmtaller2.katyaherrera00188119.ui.screens.Search.SearchScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    val onRestaurantClick: (Int) -> Unit = { id ->
        navController.navigate(MenuScreenNavigation(id))
    }

    NavHost(navController = navController, startDestination = RestaurantListScreenNavigation) {
        composable<RestaurantListScreenNavigation> {
            RestaurantListScreen(
                navController = navController,
                onRestaurantClick = onRestaurantClick
            )
        }
        composable<SearchScreenNavigation> {
            SearchScreen(navController = navController)
        }
        composable<OrdersScreenNavigation> {
            MyOrdersScreen()
        }
        composable<MenuScreenNavigation> { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
            MenuScreen(navController = navController, restaurantId = restaurantId)
        }
    }
}
