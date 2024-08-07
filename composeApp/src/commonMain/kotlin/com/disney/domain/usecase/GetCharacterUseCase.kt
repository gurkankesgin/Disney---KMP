package com.disney.domain.usecase

import com.disney.domain.model.Character
import com.disney.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class GetCharacterUseCase(private val repository: CharacterRepository) {

    operator fun invoke(): Flow<List<Character>?> =
        repository.getCharacters().map { it?.sortedBy { character -> character.name } }
}
