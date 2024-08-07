package com.disney.ui.screens.characterlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.disney.domain.model.Character
import disney.composeapp.generated.resources.Res
import disney.composeapp.generated.resources.disney
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import com.disney.ui.screens.characterlist.CharacterListViewModel.CharacterListUIState.Loading
import com.disney.ui.screens.characterlist.CharacterListViewModel.CharacterListUIState.Success
import com.disney.ui.screens.characterlist.item.CharacterListItem
import com.disney.ui.theme.Colors

/**
 * Created by gurkankesgin on 28.07.2024.
 */
@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel = koinInject<CharacterListViewModel>()) {
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { },
                navigationIcon = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier.fillMaxWidth(),
                            painter = painterResource(Res.drawable.disney),
                            contentDescription = null
                        )
                    }
                })
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (val state = uiState.value) {
                is Loading -> Progress()
                is Success -> CharacterList(state.data)
            }
        }

    }
}

@Composable
private fun CharacterList(list: List<Character>?) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .background(Colors.lighterGray)
            .padding(8.dp)
    ) {
        items(
            items = list.orEmpty(),
            key = { item ->
                item.id ?: 0
            }) { item ->
            CharacterListItem(
                modifier = Modifier.fillMaxWidth(),
                imageUrl = item.imageUrl,
                name = item.name
            )
        }
    }
}

@Composable
private fun Progress() {
    CircularProgressIndicator(color = Color.LightGray)
}

