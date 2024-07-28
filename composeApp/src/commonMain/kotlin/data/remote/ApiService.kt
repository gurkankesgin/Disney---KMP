package data.remote

import io.ktor.client.statement.HttpResponse


/**
 * Created by gurkankesgin on 28.07.2024.
 */
interface ApiService {
    suspend fun getCharacterResponseModel(): HttpResponse
}