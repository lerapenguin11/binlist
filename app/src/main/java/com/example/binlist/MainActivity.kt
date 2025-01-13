package com.example.binlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.binlist.screen.BinScreen
import com.example.binlist.ui.theme.BinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BinScreen(contentPadding = innerPadding)
                }
            }
        }
    }
}