package com.sasakirione.pokemon.simulator.domain.value.dynamic

import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * ポケモンの状況を担当するクラス
 *
 * @constructor 各値を設定します
 *
 * @param maxHP 最大HP
 * @param abilityName 特性の名前
 */
class Dynamic(maxHP: Int, abilityName: String) {
    /** HP */
    private val hp: HP
    /** 状態異常 */
    private var statusAilment: StatusAilment
    /** 特性 */
    private var ability: Ability

    init {
        hp = HP(maxHP)
        statusAilment = StatusAilment(StatusAilmentType.NONE)
        ability = Ability(abilityName)
    }

    /**
     * 攻撃にかかる補正値を返します
     *
     * @return 攻撃にかかる補正値倍率
     */
    fun getAttackCorrection(): Double = ability.getAttackCorrection() * statusAilment.getAttackCorrection()

    /**
     * 技のダメージにかかる補正を返します
     *
     * @param moveType 技のタイプ
     * @return 技のダメージの補正倍率値
     */
    fun getMoveDamageCorrection(moveType: TypeSelect): Double = ability.getMoveDamageCorrect(moveType, hp.isHPHalf())
}