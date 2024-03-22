package com.jersson.diaz.money.ui.detail.section

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.money.R
import com.jersson.diaz.money.theme.accountHeadboard
import com.jersson.diaz.money.ui.detail.TransactionItem

@Composable
fun ListSection(
    list: List<Transactions>
) {

    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = stringResource(id = R.string.detail_movements),
        style = accountHeadboard
    )
    Spacer(modifier = Modifier.height(10.dp))
    LazyColumn {
        items(items = list) { transactions ->
            TransactionItem(
                transactions = transactions
            )
        }
    }
}