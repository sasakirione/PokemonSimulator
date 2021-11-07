package com.sasakirione.pokemon.simulator.domain.value.nature

class NatureAll(private val ability: Ability, val nature: Nature, val type: Type) {

    fun getAttackCollection(): Double = ability.getAttackCorrection()
}