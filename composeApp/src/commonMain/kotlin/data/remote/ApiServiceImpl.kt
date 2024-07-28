package data.remote

import data.remote.ApiConstants.ApiEndpoint.GetCharacterList
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class ApiServiceImpl : ApiService {

    private val client: HttpClient
        get() = HttpClient {
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = ApiConstants.BASE_URL
                }
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        explicitNulls = false
                        ignoreUnknownKeys = true
                    },
                    contentType = ContentType.Application.Json
                )
            }
        }


    override suspend fun getCharacterResponseModel(): HttpResponse {
        return client.get(GetCharacterList.path)
    }
}