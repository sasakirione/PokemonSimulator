package com.sasakirione.pokemon.simulator.domain.value.nature

/**
 * 特性を担当するクラス
 * @param abilityName 特性の名前
 */
class Ability(private val abilityName: String) {
    fun getAttackCorrection(): Double = when (abilityName) {
        else -> 1.0
    }

}