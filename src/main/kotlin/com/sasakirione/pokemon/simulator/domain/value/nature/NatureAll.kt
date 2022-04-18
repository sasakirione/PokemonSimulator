package com.sasakirione.pokemon.simulator.domain.value.nature

import com.sasakirione.pokemon.simulator.domain.value.move.Move

/**
 * 性格やタイプを担当するクラス
 *
 * @property nature 性格のインスタンス
 * @property type タイプのインスタンス
 * @constructor 性格やタイプを設定します
 */
class NatureAll(val nature: Nature, private var type: Type) {
    fun isTypeMatch(moveType: TypeSelect): Boolean = type.isMatch(moveType)

    fun getTypeCompatibility(move: Move) = type.getTypeCompatibility(move)
}