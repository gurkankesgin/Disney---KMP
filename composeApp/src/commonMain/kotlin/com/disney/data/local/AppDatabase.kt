package com.disney.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.disney.data.local.dao.CharacterDao
import com.disney.data.local.entity.CharacterEntity


/**
 * Created by gurkankesgin on 7.08.2024.
 */
@Database(entities = [CharacterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(), DB {

    abstract fun characterDao(): CharacterDao

    // fixme: remove this after room updated
    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// fixme: remove after this room updated
interface DB {
    fun clearAllTables() {}
}