package com.vini.creditcardpay.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

@Composable
fun FoundationRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Surface {
        Row(
            modifier = modifier.composed {
                wrapContentHeight()
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 18.dp
                    )
            }
        ) {
            content()
        }
    }
}