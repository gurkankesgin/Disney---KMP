package ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import disney.composeapp.generated.resources.Res
import disney.composeapp.generated.resources.disney
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource


/**
 * Created by gurkankesgin on 29.07.2024.
 */
@Composable
fun SplashScreen(
    onNavigate: () -> Unit,
) {
    LaunchedEffect(Unit) {
        delay(1000)
        onNavigate.invoke()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(Res.drawable.disney),
            contentDescription = null
        )
    }
}