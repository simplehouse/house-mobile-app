package io.devmartynov.house.ui.screen.invoices.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.R
import io.devmartynov.house.ui.screen.invoices.model.InvoiceAction
import io.devmartynov.house.ui.shared.Symbol
import io.devmartynov.house.ui.theme.*

@Composable
fun InvoiceItem(
    modifier: Modifier = Modifier,
    date: String,
    amount: Float,
    canManipulateFile: Boolean,
    onOptionSelected: (action: InvoiceAction) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.heightIn(75.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Symbol(
                imageVector = Icons.Default.CalendarMonth,
                tint = Blue,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.label_meter_reading_create_date, date),
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(id = R.string.label_amount, amount.toString()),
                    fontFamily = GilroyFontMedium,
                    color = Grey,
                    fontSize = 14.sp,
                )
            }
            Icon(
                modifier = Modifier.clickable(
                    onClickLabel = "",
                    onClick = {
                        expanded = !expanded
                    }
                ),
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = Grey,
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 0.dp),
        ) {
            InvoiceAction.values().forEach { action ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(action)
                        expanded = false
                    },
                ) {
                    Text(
                        text = stringResource(id = action.label),
                        fontSize = 18.sp,
                        fontFamily = GilroyFontMedium,
                        lineHeight = 25.sp,
                        color = if (canManipulateFile) {
                            Black
                        } else {
                            Grey
                        },
                    )
                }
            }
        }
    }
}