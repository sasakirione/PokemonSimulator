package com.sasakirione.pokemon.simulator.domain.value.move

import com.sasakirione.pokemon.simulator.data.PokemonMoveDataGet
import com.sasakirione.pokemon.simulator.data.PokemonMoveDataGetInterface
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

class Move(val name: String, val moveType: TypeSelect) {

    init {
        val moveGet: PokemonMoveDataGetInterface = PokemonMoveDataGet()
        val moveStatusList = moveGet.getMove(name)
    }

    class MoveBuilder() {

    }
}