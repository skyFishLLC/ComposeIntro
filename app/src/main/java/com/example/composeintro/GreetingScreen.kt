package com.example.composeintro

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeintro.ui.theme.ComposeIntroTheme

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: GreetingViewModel
) {
    val state = viewModel.state.value
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .border(width = 4.dp, Color.Green)
                .background(Color.LightGray)
                .padding(16.dp),
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = state.message,
            modifier = modifier
                .padding(16.dp),
            fontSize = 40.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                viewModel.setMessage(true)
            }) {
                Text(
                    text = "Fine",
                    fontSize = 28.sp
                )
            }
            Button(onClick = {
                viewModel.setMessage(false)
            }) {
                Text(
                    text = "Bad",
                    fontSize = 28.sp,
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroTheme {
        val viewModel = GreetingViewModel()
        Greeting(
            name = "Tim",
            viewModel = viewModel
        )
    }
}