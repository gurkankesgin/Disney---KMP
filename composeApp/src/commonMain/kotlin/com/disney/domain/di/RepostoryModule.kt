package com.disney.domain.di

import com.disney.data.repository.CharacterRepositoryImpl
import com.disney.domain.repository.CharacterRepository
import org.koin.dsl.module


/**
 * Created by gurkankesgin on 28.07.2024.
 */
val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get(),get()) }
}