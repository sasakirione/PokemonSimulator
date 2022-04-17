package com.sasakirione.pokemon.simulator.domain.value.dynamic

import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * ポケモンの状況を担当するクラス
 *
 * @constructor 各値を設定します
 *
 * @param maxHP 最大HP
 * @param ability 特性
 * @param good 道具
 */
class Dynamic(maxHP: Int, ability: Ability, good: Good) {
    /** HP */
    private val hp: HP

    /** 状態異常 */
    private var statusAilment: StatusAilment

    /** 特性 */
    private var ability: Ability

    /** 道具 */
    private var good: Good

    init {
        hp = HP(maxHP)
        statusAilment = StatusAilment(StatusAilmentType.NONE)
        this.ability = ability
        this.good = good
    }

    /**
     * 攻撃にかかる補正値を返します
     *
     * @return 攻撃にかかる補正値倍率
     */
    fun getAttackCorrection(): Double =
        ability.getAttackCorrection() * statusAilment.getAttackCorrection() * good.getAttackCorrection()

    /**
     * 特攻にかかる補正値を返します
     *
     * @return 特攻にかかる補正値倍率
     */
    fun getSpecialAttackCorrection(): Double =
        ability.getSpecialAttackCorrection() * good.getSpAttackCorrection()

    /**
     * 防御にかかる補正値を返します
     *
     * @return 防御にかかる補正値倍率
     */
    fun getDefenseCorrection(): Double =
        ability.getDefenseCorrection() * good.getDefenseCorrection()

    /**
     * 特防にかかる補正値を返します
     *
     * @return 特防にかかる補正値倍率
     */
    fun getSpecialDefenseCorrection(): Double =
        ability.getSpecialDefenseCorrection() * good.getSpecialDefenseCorrection()

    /**
     * 素早さにかかる補正値を返します
     *
     * @return 素早さにかかる補正値倍率
     */
    fun getSpeedCorrection(): Double =
        ability.getSpeedCorrection() * statusAilment.getSpeedCorrection() * good.getSpeedCorrection()

    /**
     * 技のダメージにかかる補正を返します
     *
     * @param moveType 技のタイプ
     * @return 技のダメージの補正倍率値
     */
    fun getMoveDamageCorrection(moveType: TypeSelect): Double =
        ability.getMoveDamageCorrect(moveType, hp.isHPOneThird()) * good.getMoveDamageCorrect(moveType)

    fun getAbility(): Ability = this.ability

    fun takeDamage(damage: Int) {
        hp.decreaseHP(damage)
    }




}