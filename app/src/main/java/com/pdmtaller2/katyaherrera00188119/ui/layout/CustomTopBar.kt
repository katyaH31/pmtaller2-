package com.pdmtaller2.katyaherrera00188119.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopBar(
    title: String = "FoodSpot",
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                if (showBackButton) onBackClick()
            }) {
                Icon(
                    imageVector = if (showBackButton) Icons.Filled.ArrowBackIosNew else Icons.Filled.Menu,
                    contentDescription = if (showBackButton) "Volver" else "Menú"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title)
        }

        Row {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar"
                )
            }
            IconButton(onClick = { /* Acción de perfil */ }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Perfil"
                )
            }
        }
    }
}
