package com.thee_cap.justindia.model

data class StateInfo(
    val name: String,
    val imageResId: Int
)
data class Spot(
    val id: Int,
    val name: String,
    val imageResIds: List<Int>,
    val description: String,
    val location: String,
    val bestTimeToVisit: String,
    val estimatedBudget: String,
    val famousFor: String,
    val travelTips: String
)
