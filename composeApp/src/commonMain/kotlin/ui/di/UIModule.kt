package ui.di

import org.koin.dsl.module
import ui.screens.characterlist.CharacterListViewModel


/**
 * Created by gurkankesgin on 28.07.2024.
 */
val uiModule = module {
    factory { CharacterListViewModel(get()) }
}