package com.sasakirione.pokemon.simulator.domain.value.status

import kotlin.math.floor

class Status(individual: Individual, effort: Effort, base: Base) {
    /** 補正なし実数値 */
    private val realSource: List<Pair<StatusType, Int>>
    /** 実数値 */
    private var real: MutableList<Pair<StatusType, Int>>

    init {
        realSource = listOf(
            StatusType.H to realCalculationHP(base.getH(), individual.getH(), effort.getH()),
            StatusType.A to realCalculationEtc(base.getA(), individual.getA(), effort.getA()),
            StatusType.B to realCalculationEtc(base.getB(), individual.getB(), effort.getB()),
            StatusType.C to realCalculationEtc(base.getC(), individual.getC(), effort.getC()),
            StatusType.D to realCalculationEtc(base.getD(), individual.getD(), effort.getD()),
            StatusType.S to realCalculationEtc(base.getS(), individual.getS(), effort.getS())
        )

        real = realSource.toMutableList()
    }

    private fun realCalculationHP(base: Int, individual: Int, effort: Int): Int {
        return floor((base * 2.0 + individual + floor(effort / 4.0)) * (50.0 / 100.0) + 50 + 10).toInt()
    }

    private fun realCalculationEtc(base: Int, individual: Int, effort: Int): Int {
        return floor((base * 2.0 + individual + floor(effort / 4.0)) * (50.0 / 100.0) + 5).toInt()
    }
}