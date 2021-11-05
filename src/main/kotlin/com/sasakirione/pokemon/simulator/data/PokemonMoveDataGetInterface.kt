package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.domain.value.move.MoveStatusType

interface PokemonMoveDataGetInterface {
    fun getMove(name: String): List<Pair<MoveStatusType, Int>>
}