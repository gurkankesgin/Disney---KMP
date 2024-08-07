package com.disney.domain.di

import com.disney.domain.usecase.GetCharacterUseCase
import org.koin.core.module.Module
import org.koin.dsl.module


/**
 * Created by gurkankesgin on 28.07.2024.
 */
val useCaseModule: Module = module {
    factory { GetCharacterUseCase(get()) }
}