package com.thee_cap.justindia.viewmodel

import androidx.lifecycle.ViewModel
import com.thee_cap.justindia.R
import com.thee_cap.justindia.model.Spot

class SpotViewModel : ViewModel() {

    fun getSpotsForState(stateName: String): List<Spot> {
        return when (stateName) {
            "Uttar Pradesh" -> listOf(
                Spot(
                    id = 1,
                    name = "Taj Mahal",
                    imageResIds =listOf(R.drawable.taj_mahal,R.drawable.t2),
                    description = "The Taj Mahal is an ivory-white marble mausoleum on the south bank of the Yamuna river in Agra.",
                    location = "Agra, Uttar Pradesh",
                    bestTimeToVisit = "October to March",
                    estimatedBudget = "₹5000 - ₹10000",
                    famousFor = "Architecture, Symbol of Love",
                    travelTips = "Visit early morning to avoid long queues."
                ),
                Spot(
                    id = 2,
                    name = "Varanasi Ghats",
                    imageResIds = listOf(R.drawable.varanasi_ghats,R.drawable.v2),
                    description = "The ghats of Varanasi are world-famous for their spiritual ambiance.",
                    location = "Varanasi, Uttar Pradesh",
                    bestTimeToVisit = "October to March",
                    estimatedBudget = "₹4000 - ₹8000",
                    famousFor = "Spirituality, Temples, Ganga Aarti",
                    travelTips = "Attend the evening Ganga Aarti at Dashashwamedh Ghat."
                )
            )

            "Rajasthan" -> listOf(
                Spot(
                    id = 3,
                    name = "Hawa Mahal",
                    imageResIds = listOf( R.drawable.hawa_mahal,R.drawable.h2),
                    description = "The Hawa Mahal is a palace in Jaipur, made with red and pink sandstone.",
                    location = "Jaipur, Rajasthan",
                    bestTimeToVisit = "November to February",
                    estimatedBudget = "₹4000 - ₹9000",
                    famousFor = "Architecture, Royal History",
                    travelTips = "Visit during morning for perfect lighting for photographs."
                ),
                Spot(
                    id = 4,
                    name = "Jaisalmer Fort",
                    imageResIds = listOf( R.drawable.jaisalmer_fort,R.drawable.jf2),
                    description = "One of the few 'living forts' in the world where a quarter of the city's population still resides.",
                    location = "Jaisalmer, Rajasthan",
                    bestTimeToVisit = "October to March",
                    estimatedBudget = "₹6000 - ₹12000",
                    famousFor = "Desert Culture, Architecture",
                    travelTips = "Stay overnight inside the fort for a unique experience."
                )
            )



            else -> emptyList()
        }
    }
}
