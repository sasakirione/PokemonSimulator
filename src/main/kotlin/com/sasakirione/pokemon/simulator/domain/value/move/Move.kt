package com.sasakirione.pokemon.simulator.domain.value.move

import com.sasakirione.pokemon.simulator.const.CalculationConst
import com.sasakirione.pokemon.simulator.data.PokemonMoveDataGet
import com.sasakirione.pokemon.simulator.data.PokemonMoveDataGetInterface
import com.sasakirione.pokemon.simulator.domain.entity.Pokemon
import com.sasakirione.pokemon.simulator.domain.value.move.MoveClass.*
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.utility.CalculationUtility.fiveOutOverFiveIn
import kotlin.math.floor

/**
 * ポケモンの技を担当するクラス
 * @param name 技の名前
 * @param pokemon 技を出すポケモンのインスタンス
 */
class Move(val name: String, val pokemon: Pokemon) {
    /** 技のタイプ */
    val moveType: TypeSelect

    /** 技の威力 */
    private val movePower: Int

    /** 技の種類 */
    val moveClass: MoveClass

    /** 技の優先度 */
    val priority: Int

    /** 技の命中率 */
    private val accuracy: Int

    /** 技の連続仕様 */
    val moveCombo: MoveCombo

    /** 技の急所ランク */
    val vitalRank: VitalRank

    /** 技のターン消費仕様 */
    val multipleMove: MultipleMove

    /** 接触技判定(trueの場合は接触技) */
    val contact: Boolean

    init {
        val moveGet: PokemonMoveDataGetInterface = PokemonMoveDataGet()
        val inDTO = moveGet.getMove(name)
        this.moveType = inDTO.moveType
        this.movePower = inDTO.movePower
        this.moveClass = inDTO.moveClass
        this.priority = inDTO.priority
        this.accuracy = inDTO.accuracy
        this.moveCombo = inDTO.moveCombo
        this.vitalRank = inDTO.vitalRank
        this.multipleMove = inDTO.multipleMove
        this.contact = inDTO.contact
    }

    /**
     * 技の威力を返す
     *
     * @return
     */
    fun getDamage(): Int {
        return movePower
    }

    /**
     * 技の防御計算前の威力(攻撃指数)を返します
     *
     * @return 防御計算前の技の威力(攻撃指数)
     */
    fun getAttackDamage(): Int {
        val power = when (moveClass) {
            PHYSICS -> pokemon.getRealAttack()
            SPECIAL -> pokemon.getRealSpecialAttack()
            else -> return 0
        }
        val damage1 = floor(CalculationConst.LEVEL_50* 0.4 + 2)
        val damage2 = floor(damage1 * movePower * power)
        return fiveOutOverFiveIn(damage2 * pokemon.getMoveDamageCorrection(moveType))
    }

    fun isTypeMatch(): Boolean = pokemon.isTypeMatch(moveType)


}