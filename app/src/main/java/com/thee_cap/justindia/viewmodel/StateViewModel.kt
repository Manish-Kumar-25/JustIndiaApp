package com.thee_cap.justindia.viewmodel

import androidx.lifecycle.ViewModel
import com.thee_cap.justindia.R
import com.thee_cap.justindia.model.StateInfo

class StateViewModel : ViewModel() {

    val stateList = listOf(
        StateInfo("Rajasthan", R.drawable.rajasthan),
        StateInfo("Uttar Pradesh", R.drawable.varanasi_ghats),
        StateInfo("Kerala", R.drawable.kerala),
        StateInfo("Goa", R.drawable.goa),
        StateInfo("Bihar", R.drawable.bihar),
        StateInfo("Punjab", R.drawable.punjab),
        StateInfo("Tamil Nadu", R.drawable.tamil_nadu),
        StateInfo("Gujarat", R.drawable.gujarat),
        StateInfo("West Bengal", R.drawable.west_bengal)

    )
}
