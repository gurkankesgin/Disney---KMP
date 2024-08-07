package com.disney.data.di

import com.disney.data.cache.getAppDatabase
import com.disney.data.local.AppDatabase
import org.koin.dsl.module

actual val localModule = module {
    single<AppDatabase> {
        getAppDatabase()
    }
}