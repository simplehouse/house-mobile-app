package io.devmartynov.house.ui.screen.invoices.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import io.devmartynov.house.R
import io.devmartynov.house.app.helpers.Utils
import io.devmartynov.house.domain.model.InvoiceEntity
import io.devmartynov.house.ui.screen.invoices.model.InvoicesEvent
import io.devmartynov.house.ui.screen.invoices.model.InvoicesState
import io.devmartynov.house.ui.shared.Divider
import io.devmartynov.house.ui.theme.Blue
import io.devmartynov.house.ui.theme.White

@Composable
fun InvoicesContent(
    modifier: Modifier = Modifier,
    uiState: InvoicesState,
    handleEvent: (event: InvoicesEvent) -> Unit,
    onBackPressed: () -> Unit,
) {
    val isLoading = uiState.invoicesStatus.isLoading()

    TopAppBar(
        modifier = Modifier.zIndex(1f),
        backgroundColor = MaterialTheme.colors.surface,
        contentPadding = PaddingValues(start = 15.dp),
        elevation = 0.dp,
    ) {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(
                modifier = Modifier.clickable(
                    onClickLabel = stringResource(id = R.string.cd_go_back),
                    onClick = onBackPressed
                ),
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.label_invoices),
                style = MaterialTheme.typography.h2,
            )
        }
    }
    Spacer(modifier = modifier.height(90.dp))
    LazyColumn(
        modifier = modifier
            .background(color = White)
            .padding(
                top = 60.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (uiState.invoices.isEmpty() && !isLoading) {
            item {
                Text(
                    modifier = Modifier.padding(top = 80.dp),
                    text = stringResource(id = R.string.label_no_meter_readings)
                )
            }
        }
        if (isLoading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(55.dp)
                        .padding(top = 80.dp),
                    color = Blue,
                )
            }
        }
        items(uiState.invoices) { invoice: InvoiceEntity ->
            InvoiceItem(
                date = Utils.formatDateString(invoice.createTime),
                amount = invoice.getToPayAmount(),
                onOptionSelected = { action ->

                }
            )
            Divider(
                startIndent = 30.dp,
                endIndent = 30.dp,
            )
        }
        item {
            Spacer(modifier = modifier.height(20.dp))
        }
    }
}