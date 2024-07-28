package data.repository

import data.remote.ApiService
import data.remote.model.Character
import data.remote.model.CharacterListModel
import domain.repository.CharacterRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class CharacterRepositoryImpl(private val apiService: ApiService) : CharacterRepository {

    override suspend fun getCharacters(): Flow<List<Character>?> = flow {
        val httpResponse = apiService.getCharacterResponseModel()
        val responseModel = httpResponse.body<CharacterListModel>()
        emit(responseModel.data)
    }
}