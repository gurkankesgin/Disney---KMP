package com.disney.data.remote

import com.disney.data.remote.ApiConstants.ApiEndpoint.GetCharacterList
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class ApiServiceImpl(private val client: HttpClient) : ApiService {

    override suspend fun getCharacterResponseModel(): HttpResponse {
        return client.get(GetCharacterList.path)
    }
}