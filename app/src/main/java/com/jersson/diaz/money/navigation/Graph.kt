package com.jersson.diaz.money.navigation

import androidx.navigation.compose.composable
import androidx.core.util.Function
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.money.model.AccountState
import com.jersson.diaz.money.model.UiStateHolder
import com.jersson.diaz.money.ui.account.ListScreen
import com.jersson.diaz.money.ui.detail.DetailScreen
import com.jersson.diaz.money.ui.init.LoginScreen

fun NavGraphBuilder.graph(
    state: () -> AccountState,
    uiState: () -> UiStateHolder,
    validateUser: Function<User, Unit>,
    goDetail: Function<Account, Unit>,
    finish: Runnable,
) {
    navigation(
        startDestination = NavigationScreen.LoginScreen.screen,
        route = NavigationHost.InitNavHost.route
    ) {
        composable(NavigationScreen.LoginScreen.screen) {
            LoginScreen(
                validateUser = validateUser,
                uiState = uiState.invoke(),
            )
        }
        composable(NavigationScreen.AccountScreen.screen) {
            ListScreen(
                list = state().list,
                goDetail = goDetail,
                uiState = uiState.invoke(),
                finish = finish,
            )
        }
        composable(NavigationScreen.DetailScreen.screen) {
            DetailScreen(
                account = state().accountSelected
            )
        }
    }
}