package com.jersson.diaz.money.ui.init

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.money.model.UiStateHolder
import com.jersson.diaz.money.ui.init.section.ErrorSection
import com.jersson.diaz.money.ui.init.section.SuccessSection

@Composable
fun LoginScreen(
    validateUser: Function<User, Unit>,
    uiState: UiStateHolder,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SuccessSection(validateUser)

        ErrorSection(uiState.isErrorVisible)
    }
}