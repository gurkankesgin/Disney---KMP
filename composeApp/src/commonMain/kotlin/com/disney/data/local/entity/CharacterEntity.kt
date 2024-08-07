package com.disney.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.disney.domain.model.Character


/**
 * Created by gurkankesgin on 7.08.2024.
 */

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey val id: Int?,
    val imageUrl: String?,
    val name: String?,
)

fun CharacterEntity.toDomain() = Character(
    imageUrl = imageUrl,
    name = name,
    id = id
)
