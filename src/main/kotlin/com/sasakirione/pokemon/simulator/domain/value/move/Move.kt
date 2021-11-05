package com.sasakirione.pokemon.simulator.domain.value.move

import com.sasakirione.pokemon.simulator.data.PokemonMoveDataGet
import com.sasakirione.pokemon.simulator.data.PokemonMoveDataGetInterface
import com.sasakirione.pokemon.simulator.domain.entity.Pokemon
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * ポケモンの技を担当するクラス
 * @param name 技の名前
 * @param pokemon 技を出すポケモンのインスタンス
 */
class Move(val name: String, val pokemon: Pokemon) {
    /** 技のタイプ */
    val moveType: TypeSelect
    /** 技の威力 */
    val movePower: Int
    /** 技の種類 */
    val moveClass: MoveClass
    /** 技の優先度 */
    val priority: Int
    /** 技の命中率 */
    val accuracy: Int
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

}