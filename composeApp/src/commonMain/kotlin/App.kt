import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import di.networkModule
import di.repositoryModule
import di.uiModule
import di.useCaseModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import ui.screens.characterlist.CharacterListScreen
import ui.navigation.Route

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinApplication(
            application = {
                modules(listOf(networkModule, repositoryModule, useCaseModule, uiModule))
            }
        ) {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.CharacterList.route
    ) {
        composable(
            Route.CharacterList.route
        ) {
            CharacterListScreen()
        }
    }
}
