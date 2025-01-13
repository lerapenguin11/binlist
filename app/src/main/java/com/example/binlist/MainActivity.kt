package com.example.binlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.binlist.component.topbar.TopAppBar
import com.example.binlist.nav.MainGraph
import com.example.binlist.ui.theme.BinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BinTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .systemBarsPadding(),
                    containerColor = Color.White,
                    contentWindowInsets = WindowInsets.statusBars,
                    topBar = {
                        TopAppBar(
                            navController = navController,
                            containerColor = BinTheme.colors.secondary
                        )
                    }
                )
                { innerPadding ->
                    MainGraph(
                        navController = navController,
                        contentPadding = innerPadding
                    )
                }
            }
        }
    }
}