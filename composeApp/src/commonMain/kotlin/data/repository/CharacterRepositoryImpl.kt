package data.repository

import data.remote.ApiServiceImpl
import data.remote.model.CharacterListModel
import data.remote.model.Character
import domain.repository.CharacterRepository
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class CharacterRepositoryImpl : CharacterRepository {

    private val apiService = ApiServiceImpl()

    override suspend fun getCharacters(): Flow<List<Character>?> = flow {
        val httpResponse = apiService.getCharacterResponseModel()
        val responseModel = httpResponse.body<CharacterListModel>()
        emit(responseModel.data)
    }
}