package domain.repository

import data.remote.model.CharacterListModel


/**
 * Created by gurkankesgin on 28.07.2024.
 */
interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterListModel>?
}