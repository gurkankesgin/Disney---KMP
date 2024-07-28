package data.remote


/**
 * Created by gurkankesgin on 28.07.2024.
 */

object ApiConstants {
    const val BASE_URL: String = "api.disneyapi.dev"

    sealed class ApiEndpoint(val path: String) {
        data object GetCharacterList : ApiEndpoint(path = "/character")
    }
}