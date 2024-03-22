package com.jersson.diaz.money

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.Currency
import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.money.model.AccountState
import com.jersson.diaz.money.model.MutableUiStateHolder
import com.jersson.diaz.domain.model.TypeTransaction
import com.jersson.diaz.money.model.UiState
import com.jersson.diaz.money.navigation.UIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ADMIN = "userTest1"
private const val ADMIN2 = "User@test"
private const val ADMIN3 = "user123&"
private const val PASSWORD = "passTest1"
private const val PASSWORD2 = "TestPass_"
private const val PASSWORD3 = "123456"

@HiltViewModel
class MoneyViewModel @Inject constructor(

): ViewModel() {

    private var _uiState = mutableStateOf(MutableUiStateHolder())
    val uiState: State<MutableUiStateHolder> = _uiState

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents>
        get() = _events

    private var _state = mutableStateOf(AccountState())

    val state: State<AccountState>
        get() = _state

    fun logIn(user: User){
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                currentState = UiState.LOADING
            )
            delay(2000)
            /*
            if (user.user == ADMIN && user.password == PASSWORD ||user.user == ADMIN2 && user.password == PASSWORD2 || user.user == ADMIN3 && user.password == PASSWORD3) {
                _events.emit(UIEvents.GoAccounts)
                getData()
            } else {
                _uiState.value = uiState.value.copy(
                    currentState = UiState.ERROR
                )
            }
            */
            getData()
            _events.emit(UIEvents.GoAccounts)
        }
    }

    private fun getData(){
        viewModelScope.launch(Dispatchers.IO)  {
            _uiState.value = uiState.value.copy(
                currentState = UiState.LOADING
            )
            /*
            val result = getListMoviesUseCase.invoke()
            _state.value = state.value.copy(
                listMovies = result
            )
            _uiState.value = uiState.value.copy(
                currentState = UiState.from(result)
            )
            */
            delay(2000)
            _state.value = state.value.copy(
                list = listOf(
                    Account(
                        currency = Currency.PEN,
                        amount = 1000.80,
                        numberAccount = "1111111111111",
                        list = listOf(
                            Transactions(
                                description = "Transferencia",
                                date = "25 Nov 2021",
                                amount = 6.10,
                                currency = Currency.PEN,
                                typeTransaction = TypeTransaction.ADD,
                            ),
                            Transactions(
                                description = "Plin",
                                date = "25 Nov 2021",
                                amount = 10.0,
                                currency = Currency.PEN,
                                typeTransaction = TypeTransaction.LESS,
                            )
                        )
                    ),
                    Account(
                        currency = Currency.USD,
                        amount = 1600.20,
                        numberAccount = "222222222222",
                        list = listOf(
                            Transactions(
                                description = "Transferencia",
                                date = "25 Nov 2021",
                                amount = 6.10,
                                currency = Currency.PEN,
                                typeTransaction = TypeTransaction.ADD,
                            )
                        )
                    ),
                )
            )
            _uiState.value = uiState.value.copy(
                currentState = UiState.from(state.value.list)
            )
        }
    }

    fun goDetail(account: Account){
        _state.value = state.value.copy(
            accountSelected = account,
        )
        viewModelScope.launch {
            _events.emit(UIEvents.GoDetail)
        }
    }
}