package com.disney.ui.di

import org.koin.dsl.module
import com.disney.ui.screens.characterlist.CharacterListViewModel


/**
 * Created by gurkankesgin on 28.07.2024.
 */
val uiModule = module {
    factory { CharacterListViewModel(get()) }
}