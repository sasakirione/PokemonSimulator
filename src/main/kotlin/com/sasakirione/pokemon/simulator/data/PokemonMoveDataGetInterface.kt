package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.dto.MoveDTO


interface PokemonMoveDataGetInterface {
    fun getMove(name: String): MoveDTO
}