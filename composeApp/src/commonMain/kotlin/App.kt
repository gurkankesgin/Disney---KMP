import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.screens.characterlist.CharacterListScreen
import ui.navigation.Route

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppContent()
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
