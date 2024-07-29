package domain.di

import data.repository.CharacterRepositoryImpl
import domain.repository.CharacterRepository
import org.koin.dsl.module


/**
 * Created by gurkankesgin on 28.07.2024.
 */
val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}