package io.devmartynov.house.ui.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import dagger.hilt.android.AndroidEntryPoint
import io.devmartynov.house.domain.enums.Theme
import io.devmartynov.house.ui.HouseApp
import io.devmartynov.house.ui.activity.main.model.MainState
import io.devmartynov.house.ui.app.model.rememberAppState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var uiState: MainState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            uiState = mainViewModel.uiState.collectAsState().value
            val appState = rememberAppState();
            HouseApp(
                appState = appState,
                isAuthorized = uiState.isAuthorized,
                isDarkTheme = mainViewModel.isDarkTheme()
            )
            LaunchedEffect(this@MainActivity) {
                if (!uiState.isAuthorized) {
                    appState.router.navigateToSignIn()
                }
            }
        }
    }
}