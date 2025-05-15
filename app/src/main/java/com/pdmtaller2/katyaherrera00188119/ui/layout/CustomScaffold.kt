package com.pdmtaller2.katyaherrera00188119.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.katyaherrera00188119.ui.navigation.MainNavigation
import com.pdmtaller2.katyaherrera00188119.ui.navigation.RestaurantListScreenNavigation
import com.pdmtaller2.katyaherrera00188119.ui.navigation.SearchScreenNavigation
import com.pdmtaller2.katyaherrera00188119.ui.navigation.OrdersScreenNavigation
import kotlinx.coroutines.launch

@Composable
fun CustomScaffold() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

    var title by rememberSaveable { mutableStateOf("Restaurantes") }
    var selectedItem by rememberSaveable { mutableStateOf("restaurants") }

    val navItems = listOf(
        NavItem("Inicio", Icons.Filled.Home, "restaurants"),
        NavItem("Buscar", Icons.Filled.Search, "search"),
        NavItem("Órdenes", Icons.Filled.ReceiptLong, "orders")
    )

    fun onFloatingButtonClick(text: String) {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                message = text,
                actionLabel = "OK",
                duration = SnackbarDuration.Short
            )
        }
    }

    fun onItemSelected(currentItem: String) {
        selectedItem = currentItem
        title = when (currentItem) {
            "restaurants" -> "Restaurantes"
            "search" -> "Buscar Platillos"
            "orders" -> "Mis Órdenes"
            else -> "Inicio"
        }
        when (currentItem) {
            "restaurants" -> navController.navigate(RestaurantListScreenNavigation)
            "search" -> navController.navigate(SearchScreenNavigation)
            "orders" -> navController.navigate(OrdersScreenNavigation)
            else -> navController.navigate(RestaurantListScreenNavigation)
        }
    }

    Scaffold(
        topBar = {
            CustomTopBar(
                title = title,
                showBackButton = false,
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            CustomBottomBar(
                navItems = navItems,
                selectedItem = selectedItem,
                onItemSelected = { onItemSelected(it.route) }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        floatingActionButton = {
            CustomFloatingButton(
                text = "Agregar",
                onClick = { onFloatingButtonClick("Botón presionado") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainNavigation(navController = navController)
        }
    }
}