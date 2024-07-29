import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import data.di.networkModule
import domain.di.repositoryModule
import domain.di.useCaseModule
import org.koin.compose.KoinApplication
import ui.di.uiModule
import ui.navigation.Route
import ui.screens.characterlist.CharacterListScreen
import ui.screens.splash.SplashScreen

@Composable
fun App() = MaterialTheme {
    KoinApplication(
        application = {
            modules(listOf(networkModule, repositoryModule, useCaseModule, uiModule))
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
