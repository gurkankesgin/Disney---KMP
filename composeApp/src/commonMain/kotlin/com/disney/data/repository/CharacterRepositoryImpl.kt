package com.disney.data.repository

import com.disney.data.local.AppDatabase
import com.disney.data.local.entity.CharacterEntity
import com.disney.data.local.entity.toDomain
import com.disney.data.remote.ApiService
import com.disney.data.remote.model.CharacterListResponse
import com.disney.data.remote.model.toEntity
import com.disney.domain.model.Character
import com.disney.domain.repository.CharacterRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class CharacterRepositoryImpl(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase,
) : CharacterRepository {

    override fun getCharacters(): Flow<List<Character>?> = flow {
        val cachedCharacters = getLocalCharacter()
        if (cachedCharacters.isNotEmpty())
            emit(cachedCharacters)

        val entityList = getNetworkCharacter()
        entityList?.let { saveCharacters(entityList) }

        val updatedCachedCharacters = getLocalCharacter()
        emit(updatedCachedCharacters)
    }

    private suspend fun getNetworkCharacter(): List<CharacterEntity>? =
        apiService
            .getCharacterResponseModel()
            .body<CharacterListResponse>()
            .data
            ?.map {
                it.toEntity()
        }

    private suspend fun saveCharacters(user: List<CharacterEntity>) {
        appDatabase.characterDao().insertOrUpdate(user)
    }

    private suspend fun getLocalCharacter(): List<Character> {
        return appDatabase.characterDao().getAll().map { it.toDomain() }
    }
}