package com.example.binlist.nav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binlist.component.button.IconButton
import com.example.binlist.component.topbar.ProvideAppBarAction
import com.example.binlist.component.topbar.ProvideAppBarTitle
import com.example.binlist.component.topbar.TopBarText
import com.example.binlist.nav.route.Graph
import com.example.binlist.screen.BinListScreen
import com.example.binlist.screen.BinScreen
import com.example.binlist.utils.CommonDrawables
import com.example.binlist.utils.CommonString

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
            ProvideAppBarTitle(title = {
                TopBarText(text = stringResource(id = CommonString.text_bin))
            })
            ProvideAppBarAction(actions = {
                IconButton(
                    icon = CommonDrawables.ic_list,
                    contentDescription = CommonString.text_list
                ) {
                    //TODO
                }
            })
            BinScreen(contentPadding = contentPadding)
        }
        composable(route = Main.BinList.route) {
            ProvideAppBarTitle(title = {
                TopBarText(text = stringResource(CommonString.text_binlist))
            })
            BinListScreen(contentPadding = contentPadding)
        }
    }
}

sealed class Main(val route: String) {
    object Bin : Main(route = "bin_screen")
    object BinList : Main(route = "bin_list_screen")
}