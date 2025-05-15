package com.pdmtaller2.katyaherrera00188119.ui.navigation

import MenuScreen
import MyOrdersScreen
import RestaurantListScreen
import com.pdmtaller2.katyaherrera00188119.ui.screens.Search.SearchScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavigation(navController: NavHostController) {
    val onRestaurantClick: (Int) -> Unit = { id ->
        navController.navigate(MenuScreenNavigation(id))
    }

    NavHost(navController = navController, startDestination = RestaurantListScreenNavigation) {
        composable<RestaurantListScreenNavigation> {
            RestaurantListScreen(onRestaurantClick = onRestaurantClick)
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
