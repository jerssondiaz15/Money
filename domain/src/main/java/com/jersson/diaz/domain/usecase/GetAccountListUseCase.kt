package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.Currency
import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.domain.model.TypeTransaction
import javax.inject.Inject

class GetAccountListUseCase @Inject constructor(
    //private val iAccountRepository: IAccountRepository
) {
    suspend operator fun invoke(): List<Account> {
        return listOf(
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
    }
}