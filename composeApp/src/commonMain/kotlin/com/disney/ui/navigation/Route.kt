package com.disney.ui.navigation


/**
 * Created by gurkankesgin on 28.07.2024.
 */

sealed class Route(val name: String) {

    data object CharacterList : Route(name = "CharacterList")
    data object Splash : Route(name = "Splash")
}