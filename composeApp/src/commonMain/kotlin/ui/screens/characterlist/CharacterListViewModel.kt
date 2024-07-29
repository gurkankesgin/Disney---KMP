package ui.screens.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.remote.model.Character
import domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class CharacterListViewModel(private var useCase: GetCharacterUseCase?) : ViewModel() {

    private val _uiState = MutableStateFlow<CharacterListUIState>(CharacterListUIState.Loading)
    val uiState: StateFlow<CharacterListUIState> = _uiState.asStateFlow()

    init {
        getResult()
    }

    private fun getResult() {
        viewModelScope.launch {
            useCase?.invoke()?.onEach {
                _uiState.value = CharacterListUIState.Success(it)
            }?.launchIn(viewModelScope)
        }
    }

    sealed class CharacterListUIState {
        data object Loading : CharacterListUIState()
        data class Success(
            val data: List<Character>? = null,
        ) : CharacterListUIState()
    }
}