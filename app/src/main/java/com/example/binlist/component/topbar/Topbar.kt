package com.example.binlist.component.topbar

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.FloatingWindow
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.binlist.R
import com.example.binlist.ui.theme.BinTheme
import kotlinx.coroutines.flow.filterNot

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    navController: NavController,
    containerColor: Color
) {
    val currentContentBackStackEntry by produceState(
        initialValue = null as NavBackStackEntry?,
        producer = {
            navController.currentBackStackEntryFlow
                .filterNot { it.destination is FloatingWindow }
                .collect { value = it }
        }
    )
    CenterAlignedTopAppBar(
        modifier = Modifier
            .heightIn(max = 64.dp),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = containerColor),
        navigationIcon = {
            val backPressDispatcher = LocalOnBackPressedDispatcherOwner.current
            val isBackPress =
                navController.previousBackStackEntry != null

            if (isBackPress) {
                Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    IconButton(
                        onClick = {
                            backPressDispatcher?.onBackPressedDispatcher?.onBackPressed()
                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = BinTheme.colors.accent
                        ),
                        content = {
                            Icon(painterResource(id = R.drawable.ic_arrow_back), null)
                        }
                    )
                }
            }
        },
        title = {
            Row(Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
                AppBarTitle(currentContentBackStackEntry)
            }
        },
        actions = {
            Row(Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
                AppBarAction(currentContentBackStackEntry)
            }
        }
    )
}