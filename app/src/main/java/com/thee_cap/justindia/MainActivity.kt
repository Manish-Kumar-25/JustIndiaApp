package com.thee_cap.justindia

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import com.thee_cap.justindia.ui.theme.JustIndiaTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.thee_cap.justindia.navigation.NavGraph
import com.thee_cap.justindia.ui.screens.StateScreen


class MainActivity : ComponentActivity() {
    var isSplashScreenVisible = true
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply{
            setKeepOnScreenCondition {isSplashScreenVisible}
            setOnExitAnimationListener {splashScreenViewProvider ->
                val ZoomX = ObjectAnimator.ofFloat(
                    splashScreenViewProvider.iconView,
                    "scaleX",
                    0.4f,
                    0f
                )
                val ZoomY = ObjectAnimator.ofFloat(
                    splashScreenViewProvider.iconView,
                    "scaleY",
                    0.4f,
                    0f
                )
                ZoomX.duration = 2000
                ZoomY.duration = 2000
                ZoomY.doOnStart { splashScreenViewProvider.iconView.visibility = View.VISIBLE }
                ZoomX.doOnEnd { splashScreenViewProvider.remove()  }
                ZoomY.doOnEnd { splashScreenViewProvider.remove()  }
                ZoomX.start()
                ZoomY.start()
            }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController)

        }
        CoroutineScope(Dispatchers.IO).launch{
            delay(1200)
            isSplashScreenVisible = false
        }
    }
}


