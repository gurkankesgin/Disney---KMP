package com.disney.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.disney.data.local.entity.CharacterEntity


/**
 * Created by gurkankesgin on 7.08.2024.
 */
@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    suspend fun getAll(): List<CharacterEntity>

    @Upsert
    suspend fun insertOrUpdate(entity: List<CharacterEntity>)

    @Delete
    suspend fun delete(entity: CharacterEntity)


}