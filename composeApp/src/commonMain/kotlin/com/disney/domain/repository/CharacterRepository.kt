package com.disney.domain.repository

import com.disney.domain.model.Character
import kotlinx.coroutines.flow.Flow


/**
 * Created by gurkankesgin on 28.07.2024.
 */
interface CharacterRepository {
    fun getCharacters(): Flow<List<Character>?>
}