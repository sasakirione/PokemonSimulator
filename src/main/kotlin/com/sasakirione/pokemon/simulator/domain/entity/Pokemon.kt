package com.sasakirione.pokemon.simulator.domain.entity

import com.sasakirione.pokemon.simulator.domain.value.dynamic.Dynamic
import com.sasakirione.pokemon.simulator.domain.value.nature.NatureAll
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.domain.value.status.Status
import kotlin.math.roundToInt

/**
 * ポケモンを表現するエンティティクラス
 *
 * @param status 能力値に関するインスタンス
 * @param dynamic 状況に関するインスタンス
 * @param natureAll 性格やタイプに関するインスタンス
 */
class Pokemon(private val status: Status, private val dynamic: Dynamic, private val natureAll: NatureAll) {
    /**
     * ポケモンの攻撃実数値を取得する
     *
     * @return 攻撃実数値
     */
    fun getRealAttack(): Int = (status.getA() * dynamic.getAttackCorrection()).roundToInt()

    /**
     * ポケモンのダメージの補正倍率値を取得する
     *
     * @param moveType 技のタイプ
     * @return ダメージの補正倍率
     */
    fun getMoveDamageCorrection(moveType: TypeSelect): Double = (dynamic.getMoveDamageCorrection(moveType))
}