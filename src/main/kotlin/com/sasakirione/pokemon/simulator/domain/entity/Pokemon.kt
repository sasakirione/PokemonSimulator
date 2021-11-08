package com.sasakirione.pokemon.simulator.domain.entity

import com.sasakirione.pokemon.simulator.domain.value.dynamic.Dynamic
import com.sasakirione.pokemon.simulator.domain.value.nature.NatureAll
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.domain.value.status.Status
import kotlin.math.roundToInt

/**
 * ポケモンを表現するエンティティクラス
 */
class Pokemon(private val status: Status, private val dynamic: Dynamic, private val natureAll: NatureAll) {

    fun getRealAttack(): Int = (status.getA() * dynamic.getAttackCorrection()).roundToInt()

    fun getMoveDamageCorrect(moveType: TypeSelect): Double = (dynamic.getMoveDamageCorrection(moveType))
}