package com.sasakirione.pokemon.simulator.domain.usecase

import com.sasakirione.pokemon.simulator.domain.entity.Stadium
import com.sasakirione.pokemon.simulator.domain.value.move.Move

class Battle(private val stadium: Stadium) {
    fun forwardTurn(sideA: String, sideB: String) {
        val moveSideA = Move(sideA, stadium.sideA.getCurrentPokemon())
        val moveSideB = Move(sideB, stadium.sideB.getCurrentPokemon())


    }
}