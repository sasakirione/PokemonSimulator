package com.sasakirione.pokemon.simulator.domain.value.field

import com.sasakirione.pokemon.simulator.const.CalculationConst
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * フィールドを担当するクラス
 * @param field フィールドの種類
 */
class Field(private val field: FieldType) {
    /** 残りターン数 */
    var remainingTurnNumber: Int = 5
        private set

    /**
     * 残りターン数を減らす
     * @return 残りターン数が0になったらtrueを返す
     */
    fun forwardTurn(): Boolean {
        if(remainingTurnNumber == 1) {
            return true
        }
        remainingTurnNumber -= 1
        return false
    }

    /**
     * 技のタイプごとにかかるフィールドによる倍率を返します
     * @return 技のダメージ倍率
     */
    fun typeBoost(type: TypeSelect): Double = when {
        field == FieldType.ELECTRIC_FIELD && type == TypeSelect.ELECTRIC
            -> CalculationConst.ONE_POINT_THREE
        field == FieldType.GRASS_FIELD && type == TypeSelect.GRASS
            -> CalculationConst.ONE_POINT_THREE
        field == FieldType.MIST_FIELD && type == TypeSelect.FAIRLY
            -> CalculationConst.ONE_POINT_FIVE
        field == FieldType.MIST_FIELD && type == TypeSelect.DRAGON
            -> CalculationConst.HALF
        field == FieldType.PSYCHO_FIELD && type == TypeSelect.PSYCHIC
            -> CalculationConst.ONE_POINT_THREE
        else -> CalculationConst.ONE
    }
}