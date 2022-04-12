package com.sasakirione.pokemon.simulator.domain.value.dynamic

import com.sasakirione.pokemon.simulator.const.CalculationConst
import com.sasakirione.pokemon.simulator.const.GoodConst
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * 道具を担当するクラス
 *
 * @property goodName 道具の名前
 * @constructor
 */
class Good(private val goodName: String) {

    /**
     * 道具による攻撃力にかかる補正倍率を返します
     *
     * @return 攻撃力にかかる補正倍率
     */
    fun getAttackCorrection(): Double = when (goodName) {
        GoodConst.CHOICE_BAND -> CalculationConst.ONE_POINT_FIVE
        else -> 1.0
    }

    /**
     * 道具による特攻にかかる補正倍率を返します
     *
     * @return 特攻にかかる補正倍率
     */
    fun getSpAttackCorrection(): Double = when (goodName) {
        GoodConst.CHOICE_SPECS -> CalculationConst.ONE_POINT_FIVE
        else -> 1.0
    }

    /**
     * 道具による特防にかかる補正倍率を返します
     *
     * @return 特防にかかる補正倍率
     */
    fun getSpecialDefenseCorrection(): Double = when (goodName) {
        GoodConst.ASSAULT_VEST -> CalculationConst.ONE_POINT_FIVE
        else -> 1.0
    }

    /**
     * 道具による素早さにかかる補正倍率を返します
     *
     * @return 素早さにかかる補正倍率
     */
    fun getSpeedCorrection(): Double = when (goodName) {
        GoodConst.CHOICE_SCARF -> CalculationConst.ONE_POINT_FIVE
        else -> 1.0
    }

    /**
     * 道具による技のダメージの倍率を返します
     *
     * @param moveType 技のタイプ
     * @return 技のダメージの倍率
     */
    fun getMoveDamageCorrect(moveType: TypeSelect): Double = when (goodName) {
        GoodConst.LIFE_ORB -> CalculationConst.ONE_POINT_THREE_ORB
        else -> 1.0
    }

}