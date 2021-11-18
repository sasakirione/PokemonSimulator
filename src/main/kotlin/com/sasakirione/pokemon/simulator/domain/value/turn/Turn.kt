package com.sasakirione.pokemon.simulator.domain.value.turn

import com.sasakirione.pokemon.simulator.domain.entity.Pokemon
import com.sasakirione.pokemon.simulator.domain.value.move.Move
import kotlin.math.roundToInt

class Turn(sideA: Move, sideB: Move) {
    var turnCourse = TurnCourse.BEFORE

    fun go(): Turn {
        return this
    }

    companion object {
        fun compareSpeed(sideA: Pokemon, sideB: Pokemon): Int {
            val speedA = sideA.getRealSpeed()
            val speedB = sideB.getRealSpeed()
            return when {
                speedB < speedA -> 1
                speedA < speedB -> -1
                speedA == speedB -> equalsSpeed()
                else -> 1
            }
        }

        private fun equalsSpeed(): Int = when (Math.random().roundToInt()) {
            1 -> 1
            0 -> -1
            else -> 1
        }
    }
}