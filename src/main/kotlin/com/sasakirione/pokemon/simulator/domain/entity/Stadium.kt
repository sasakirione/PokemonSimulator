package com.sasakirione.pokemon.simulator.domain.entity

import com.sasakirione.pokemon.simulator.domain.value.field.FieldAll
import com.sasakirione.pokemon.simulator.domain.value.move.Move
import com.sasakirione.pokemon.simulator.domain.value.turn.Turn

/**
 * 試合自体のエンティティ
 *
 * @property sideA A側の構築
 * @property sideB B側の構築
 * @constructor フィールドの初期化
 */
class Stadium(private val sideA: Building, private val sideB: Building) {
    /**
     * フィールド
     */
    val field: FieldAll = FieldAll()

    init {

    }

    fun forwardTurn(sideA: String, sideB: String): Turn {
        val moveSideA = Move(sideA, this.sideA.getCurrentPokemon())
        val moveSideB = Move(sideB, this.sideB.getCurrentPokemon())
        return Turn(moveSideA, moveSideB).go()
    }
}