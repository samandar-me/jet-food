package com.sdk.jetfood.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sdk.jetfood.R
import com.sdk.jetfood.ui.theme.Purple500

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
@Composable
fun ShowVerticalDivider() {
    TabRowDefaults.Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = Color.LightGray.copy(alpha = 0.2f)
    )
}

@Composable
fun ShowError(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = message,
            textAlign = TextAlign.Center,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple500)
        ) {
            Text(stringResource(id = R.string.retry))
        }
    }
}