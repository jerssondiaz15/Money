package com.jersson.diaz.money.model

data class MutableUiStateHolder(override var currentState: UiState = UiState.INIT) : UiStateHolder