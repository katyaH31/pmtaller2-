// screens.kt
package com.pdmtaller2.katyaherrera00188119.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object RestaurantListScreenNavigation

@Serializable
object SearchScreenNavigation

@Serializable
object OrdersScreenNavigation

@Serializable
data class MenuScreenNavigation(val restaurantId: Int)
