package data.repository

import data.remote.ApiServiceImpl
import data.remote.model.CharacterListModel
import domain.repository.CharacterRepository
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class CharacterRepositoryImpl : CharacterRepository {

    private val apiService = ApiServiceImpl()

    override suspend fun getCharacters(): List<CharacterListModel>? =
        if (apiService.getCharacterList().status == HttpStatusCode.OK)
            apiService.getCharacterList().body()
        else
            null
}