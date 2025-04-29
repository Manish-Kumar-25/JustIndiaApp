package com.thee_cap.justindia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.thee_cap.justindia.R
import com.thee_cap.justindia.model.StateInfo
import com.thee_cap.justindia.viewmodel.StateViewModel

@Composable
fun StateScreen(
    navController: NavController,
    viewModel: StateViewModel = viewModel()
) {
    val states = viewModel.stateList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0xFFFFA500),
                        Color(0xFFEAE6DB),
                        Color(0xFF008000)
                    )
                )
            )
    ) {
        Header()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            items(states) { state ->
                StateCard(
                    state = state,
                    onClick = {
                        navController.navigate("spots/${state.name}")
                    }
                )
            }
        }
    }
}

@Composable
fun StateCard(state: StateInfo, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = state.imageResId),
                contentDescription = state.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(7.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    text = state.name,
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )
            }
        }
    }
}


@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(color = Color.Transparent),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.ji),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 35.dp, top = 50.dp)
                .scale(3f)
                .height(100.dp)
                .background(color = Color.Transparent)
        )
    }
}

