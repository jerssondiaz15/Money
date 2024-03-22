package com.jersson.diaz.money.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.jersson.diaz.money.MoneyViewModel
import androidx.navigation.compose.NavHost

@Composable
fun NavHost(
    viewModel: MoneyViewModel = hiltViewModel(),
    finish: Runnable,
){
    val navController= rememberNavController()

    Routing(
        navController = navController,
        uiEvents = viewModel.events,
    )

    NavHost(
        navController = navController,
        startDestination = NavigationHost.InitNavHost.route,
    ){
        graph(
            state = { viewModel.state.value },
            uiState = { viewModel.uiState.value },
            validateUser = viewModel::logIn,
            goDetail = viewModel::goDetail,
            finish = finish,
        )
    }
}