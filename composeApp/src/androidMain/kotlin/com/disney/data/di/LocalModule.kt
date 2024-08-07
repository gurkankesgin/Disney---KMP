package com.disney.data.di

import com.disney.DisneyApplication
import com.disney.data.local.getAppDatabase
import com.disney.data.local.AppDatabase
import org.koin.dsl.module

actual val localModule = module {
    single<AppDatabase> {
        getAppDatabase(DisneyApplication.instance.getContext())
    }
}