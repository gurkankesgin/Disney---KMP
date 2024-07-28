package ui.screens.characterlist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject


/**
 * Created by gurkankesgin on 28.07.2024.
 */
@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel = koinInject<CharacterListViewModel>()) {
    val collectAsState = viewModel.uiState.collectAsState()
    Text(collectAsState.value.toString())
}