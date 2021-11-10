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
    /** タイプによる倍率 */
    private val typeBoostConst: Double = CalculationConst.ONE_POINT_THREE

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
     * @param type 技のタイプ
     * @return 技のダメージ倍率
     */
    fun typeBoost(type: TypeSelect): Double = when(field to type) {
        FieldType.ELECTRIC_FIELD to TypeSelect.ELECTRIC -> typeBoostConst
        FieldType.GRASS_FIELD to TypeSelect.GRASS -> typeBoostConst
        FieldType.MIST_FIELD to TypeSelect.FAIRLY -> typeBoostConst
        FieldType.MIST_FIELD to TypeSelect.DRAGON -> CalculationConst.HALF
        FieldType.PSYCHO_FIELD to TypeSelect.PSYCHIC -> typeBoostConst
        else -> CalculationConst.ONE
    }

}