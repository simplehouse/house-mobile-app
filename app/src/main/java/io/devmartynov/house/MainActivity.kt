package io.devmartynov.house

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.devmartynov.house.ui.screen.auth.signIn.SignInScreen
import io.devmartynov.house.ui.screen.main.components.MeterReadingsScreen
import io.devmartynov.house.ui.screen.profile.components.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeterReadingsScreen()
//            ProfileScreen()
//            SignInScreen()
        }
    }
}