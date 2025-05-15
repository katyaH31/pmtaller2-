package com.pdmtaller2.katyaherrera00188119.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModalBottomSheet(
    sheetContent: @Composable () -> Unit,
    triggerContent: @Composable (onShow: () -> Unit) -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    var isVisible by rememberSaveable { mutableStateOf(false) }

    Box {
        triggerContent { isVisible = true }
    }

    if (isVisible) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isVisible = false }
        ) {
            sheetContent()
        }
    }
}
