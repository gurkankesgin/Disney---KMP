package domain.usecase

import domain.repository.CharacterRepository


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class GetCharacterUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke() = repository.getCharacters()
}
