package com.voitov.biptestassignment.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.voitov.biptestassignment.presentation.meetingFeature.MeetingScreen

@Composable
fun AppNavigator(navController: NavHostController, paddingValues: PaddingValues) {
    val navGraph = remember(navController) {
        navController.createGraph(startDestination = Screen.Meeting) {
            composable<Screen.Meeting> { MeetingScreen() }
        }
    }

    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        graph = navGraph,
    )
}
