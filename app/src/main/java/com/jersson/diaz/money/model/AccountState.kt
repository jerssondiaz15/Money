package com.jersson.diaz.money.model

import com.jersson.diaz.domain.model.Account

data class AccountState(
    val list: List<Account> = listOf(),
    val accountSelected: Account = Account(),
)