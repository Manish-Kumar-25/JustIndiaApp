package com.thee_cap.justindia.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thee_cap.justindia.viewmodel.SpotViewModel
import com.thee_cap.justindia.model.Spot

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotListScreen(
    stateName: String,
    spotViewModel: SpotViewModel = viewModel()
) {
    val spots = remember { spotViewModel.getSpotsForState(stateName) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "$stateName Spots", fontSize = 20.sp) }
            )
        }
    ) { padding ->
        Box(
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
                .padding(padding)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(spots) { spot ->
                    SpotCard(spot)
                }
            }
        }
    }
}


@Composable
fun SpotCard(spot: Spot) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F8F8)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                items(spot.imageResIds) { imageResId ->
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = spot.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(300.dp)
                            .height(180.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }


            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = spot.name,
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF333333),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    InfoRow(label = "📍 Location", value = spot.location)
                    InfoRow(label = "🗓️ Best Time", value = spot.bestTimeToVisit)
                    InfoRow(label = "💰 Budget", value = spot.estimatedBudget)
                    InfoRow(label = "⭐ Famous For", value = spot.famousFor)

                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "✍️ Travel Tips:\n${ spot.travelTips}",
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.DarkGray),
                        modifier = Modifier.padding(top = 6.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "ℹ️ About:\n${spot.description}",
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.DarkGray),
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 2.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF555555)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF333333)
        )
    }
}
