package domain.repository

import data.remote.model.Character
import kotlinx.coroutines.flow.Flow


/**
 * Created by gurkankesgin on 28.07.2024.
 */
interface CharacterRepository {
    suspend fun getCharacters(): Flow<List<Character>?>
}