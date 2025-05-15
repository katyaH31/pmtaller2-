package com.pdmtaller2.katyaherrera00188119.ui.layout

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun CustomBottomBar(
    navItems: List<NavItem>,
    selectedItem: String,
    onItemSelected: (NavItem) -> Unit
) {
    @Composable
    fun CustomBottomBar(
        navItems: List<NavItem>,
        selectedItem: String,
        onItemSelected: (String) -> Unit
    ) {
        NavigationBar {
            navItems.forEach { item ->
                NavigationBarItem(
                    selected = selectedItem == item.route,
                    onClick = { onItemSelected(item.route) },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                    label = { Text(item.label) }
                )
            }
        }
    }

}
