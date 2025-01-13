package com.example.binlist.nav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binlist.nav.route.Graph
import com.example.binlist.screen.BinListScreen
import com.example.binlist.screen.BinScreen

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun MainGraph(
    navController: NavHostController,
    contentPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Main.Bin.route,
        route = Graph.MAIN
    ) {
        composable(route = Main.Bin.route) {
            BinScreen(contentPadding = contentPadding)
        }
        composable(route = Main.BinList.route) {
            BinListScreen(contentPadding = contentPadding)
        }
    }
}

sealed class Main(val route: String) {
    object Bin : Main(route = "bin_screen")
    object BinList : Main(route = "bin_list_screen")
}