package com.disney.data.cache

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.disney.data.local.AppDatabase
import com.disney.data.local.instantiateImpl
import platform.Foundation.NSHomeDirectory

fun getAppDatabase(): AppDatabase {
    val dbFile = NSHomeDirectory() + "/app.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
        factory = { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .fallbackToDestructiveMigration(true)
        .build()
}