package com.disney.ui.navigation

import kotlinx.serialization.Serializable


/**
 * Created by gurkankesgin on 28.07.2024.
 */

@Serializable
sealed class Route(val path: String) {

    @Serializable
    data object Splash : Route(path = "Splash")

    @Serializable
    data object CharacterList : Route(path = "CharacterList")
}