package com.sasakirione.pokemon.simulator.domain.value.dynamic

class Dynamic(maxHP: Int) {
    private val hp: HP
    private var statusAilment: StatusAilment

    init {
        hp = HP(maxHP)
        statusAilment = StatusAilment(StatusAilmentType.NONE)
    }


    fun getAttackCorrection(): Double = when (statusAilment.statusAilment) {
        StatusAilmentType.BURNED -> 0.5
        else -> 1.0
    }
}