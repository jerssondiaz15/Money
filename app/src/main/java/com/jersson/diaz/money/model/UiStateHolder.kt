package com.jersson.diaz.money.model

interface UiStateHolder {

    var currentState: UiState

    val isLoadingVisible: Boolean
        get() = UiState.LOADING == currentState
    val isErrorVisible: Boolean
        get() = UiState.ERROR == currentState
    val isSuccessVisible: Boolean
        get() = UiState.SUCCESS == currentState
    val isEmptyVisible: Boolean
        get() = UiState.EMPTY == currentState
}