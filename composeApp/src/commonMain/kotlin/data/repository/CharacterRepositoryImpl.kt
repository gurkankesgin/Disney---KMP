package data.repository

import data.remote.ApiServiceImpl
import data.remote.model.CharacterListModel
import data.remote.model.Character
import domain.repository.CharacterRepository
import io.ktor.client.call.body


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class CharacterRepositoryImpl : CharacterRepository {

    private val apiService = ApiServiceImpl()

    override suspend fun getCharacters(): List<Character>? {
        val httpResponse = apiService.getCharacterResponseModel()
        val responseModel = httpResponse.body<CharacterListModel>()
        return responseModel.data
    }
}