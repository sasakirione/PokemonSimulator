package com.sasakirione.pokemon.simulator.domain.value.dynamic

import com.sasakirione.pokemon.simulator.const.AbilityConst
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * 特性を担当するクラス
 * @param abilityName 特性の名前
 */
class Ability(private val abilityName: String) {

    /**
     * 特性による攻撃力にかかる補正を返します
     *
     * @return 攻撃力にかかる補正
     */
    fun getAttackCorrection(): Double = when (abilityName) {
        AbilityConst.HUGE_POWER -> 2.0
        else -> 1.0
    }

    /**
     * 素早さによる攻撃力にかかる補正値を返します
     *
     * @return 素早さにかかる補正値
     */
    fun getSpeedCorrection(): Double = when (abilityName) {
        else -> 1.0
    }

    /**
     * 特性による技のダメージの倍率を返します
     *
     * @param moveType 技のタイプ
     * @param hpOneThird HPか半分以下の場合はtrue
     * @return 技のダメージの倍率
     */
    fun getMoveDamageCorrect(moveType: TypeSelect, hpOneThird: Boolean): Double = when {
        (abilityName == AbilityConst.TRANSISTOR) && (moveType == TypeSelect.ELECTRIC)
        -> 1.5
        (abilityName == AbilityConst.DRAGONS_MAW) && (moveType == TypeSelect.DRAGON)
        -> 1.5
        (abilityName == AbilityConst.BLAZE) && (moveType == TypeSelect.FIRE) && hpOneThird
        -> 1.5
        (abilityName == AbilityConst.SWARM) && (moveType == TypeSelect.BUG) && hpOneThird
        -> 1.5
        (abilityName == AbilityConst.TORRENT) && (moveType == TypeSelect.WATER) && hpOneThird
        -> 1.5
        (abilityName == AbilityConst.OVER_GROW) && (moveType == TypeSelect.GRASS) && hpOneThird
        -> 1.5
        else -> 1.0
    }



}