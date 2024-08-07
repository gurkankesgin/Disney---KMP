package com.disney.data.remote.model

import com.disney.data.local.entity.CharacterEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterListResponse(
    @SerialName("com.disney.data") val data: List<CharacterDto>?,
)

@Serializable
data class CharacterDto(
    @SerialName("_id") val id: Int?,
    @SerialName("imageUrl") val imageUrl: String?,
    @SerialName("name") val name: String?,
)

fun CharacterDto.toEntity() = CharacterEntity(
    imageUrl = imageUrl,
    name = name,
    id = id
)