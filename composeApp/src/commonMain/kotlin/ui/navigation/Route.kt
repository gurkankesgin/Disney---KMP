package ui.navigation


/**
 * Created by gurkankesgin on 28.07.2024.
 */

sealed class Route(val route: String) {

    data object CharacterList : Route(route = "CharacterList")
}