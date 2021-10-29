package com.sasakirione.pokemon.simulator.domain.value.status

class Effort(inEffort: Array<Int>) {
   private val effort: List<Pair<StatusType, Int>>

    init {
        if (inEffort.sum() > 510) {
            throw IllegalArgumentException("努力値の合計が510を超えています")
        }
        if (inEffort.any { 252 < it }) {
            throw IllegalArgumentException("252以上努力値が振られてる箇所があります")
        }
        effort = listOf(StatusType.H to inEffort[0],
                        StatusType.A to inEffort[1],
                        StatusType.B to inEffort[2],
                        StatusType.C to inEffort[3],
                        StatusType.D to inEffort[4],
                        StatusType.S to inEffort[5])
    }
}