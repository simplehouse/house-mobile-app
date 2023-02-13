package io.devmartynov.house.ui.navigation

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import io.devmartynov.house.ui.app.model.AppState
import io.devmartynov.house.ui.navigation.model.RoutesGroup
import io.devmartynov.house.ui.theme.Shapes
import io.devmartynov.house.ui.theme.White

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun Navigation(
    appState: AppState,
    isAuthorized: Boolean,
) {
    val initialRoute = if (isAuthorized) {
        RoutesGroup.MAIN.id
    } else {
        RoutesGroup.AUTH.id
    }

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    appState.navController.navigatorProvider += bottomSheetNavigator

    ModalBottomSheetLayout(
        sheetShape = Shapes.small.copy(
            topStart = CornerSize(50.dp),
            topEnd = CornerSize(50.dp),
            bottomStart = CornerSize(0.dp),
            bottomEnd = CornerSize(0.dp),
        ),
        sheetBackgroundColor = White,
        bottomSheetNavigator = bottomSheetNavigator,
    ) {
        NavHost(
            navController = appState.navController,
            startDestination = initialRoute,
        ) {
            authGraph(router = appState.router)
            mainGraph(
                router = appState.router,
                navController = appState.navController,
            )
        }
    }
}