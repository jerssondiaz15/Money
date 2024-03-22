package com.jersson.diaz.money.ui.account

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.util.Function
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.money.model.UiStateHolder
import com.jersson.diaz.money.ui.account.section.EmptyScreen
import com.jersson.diaz.money.ui.account.section.ErrorScreen
import com.jersson.diaz.money.ui.account.section.LoadingScreen
import com.jersson.diaz.money.ui.account.section.SuccessScreen

@Composable
fun ListScreen(
    list: List<Account>,
    goDetail: Function<Account, Unit>,
    uiState: UiStateHolder,
    finish: Runnable,
) {
    BackHandler {
        finish.run()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.Start,
    ) {
        EmptyScreen(uiState.isEmptyVisible)

        ErrorScreen(uiState.isErrorVisible)

        LoadingScreen(uiState.isLoadingVisible)

        SuccessScreen(uiState.isSuccessVisible, list, goDetail)
    }
}