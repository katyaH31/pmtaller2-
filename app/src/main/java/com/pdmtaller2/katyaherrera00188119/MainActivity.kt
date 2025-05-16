
package com.pdmtaller2.katyaherrera00188119

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdmtaller2.katyaherrera00188119.ui.layout.CustomScaffold
import com.pdmtaller2.katyaherrera00188119.ui.theme.FoodSpotkatyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotkatyTheme {
                CustomScaffold()
            }
        }
    }
}
