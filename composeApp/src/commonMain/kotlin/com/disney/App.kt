package com.disney

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.disney.data.di.localModule
import com.disney.data.di.networkModule
import com.disney.domain.di.repositoryModule
import com.disney.domain.di.useCaseModule
import com.disney.ui.di.uiModule
import org.koin.compose.KoinApplication
import com.disney.ui.navigation.Route
import com.disney.ui.screens.characterlist.CharacterListScreen
import ui.screens.splash.SplashScreen

@Composable
fun App() = MaterialTheme {
    KoinApplication(
        application = {
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    uiModule,
                    localModule
                )
            )
        }
    ) {
        AppContent()
    }
}


@Composable
fun AppContent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Splash.name
    ) {
        composable(
            Route.CharacterList.name
        ) {
            CharacterListScreen()
        }

        composable(
            Route.Splash.name
        ) {
            SplashScreen {
                navController.navigate(Route.CharacterList.name)
            }
        }
    }
}
