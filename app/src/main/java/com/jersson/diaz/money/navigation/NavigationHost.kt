package com.jersson.diaz.money.navigation

sealed class NavigationHost(val route: String) {
    data object InitNavHost : NavigationHost("navigation_host")
}
