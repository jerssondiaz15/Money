package com.jersson.diaz.domain.model

class Account(
    val currency: Currency = Currency.PEN,
    val amount: Double = 0.00,
    val numberAccount: String = "",
    val list: List<Transactions> = listOf(),
)