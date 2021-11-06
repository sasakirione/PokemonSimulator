package com.sasakirione.pokemon.simulator.dto

import com.sasakirione.pokemon.simulator.domain.value.move.MoveClass
import com.sasakirione.pokemon.simulator.domain.value.move.MoveCombo
import com.sasakirione.pokemon.simulator.domain.value.move.MultipleMove
import com.sasakirione.pokemon.simulator.domain.value.move.VitalRank
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * 技用のDTOクラス
 */
data class MoveDTO(
    /** 技のタイプ */
    val moveType: TypeSelect,
    /** 技の威力 */
    val movePower: Int,
    /** 技の種類 */
    val moveClass: MoveClass,
    /** 技の優先度 初期値あり(優先度0) */
    var priority: Int = 0,
    /** 技の命中率 初期値あり(命中率100%) */
    var accuracy: Int = 100,
    /** 技の連続仕様 初期値あり(連続技ではない) */
    var moveCombo: MoveCombo = MoveCombo.NORMAL,
    /** 技の急所ランク 初期値あり(急所ランクが上がったり確定急所ではない) */
    var vitalRank: VitalRank = VitalRank.ZERO,
    /** 技の複数ターン仕様 初期値あり(1ターン技) */
    var multipleMove: MultipleMove = MultipleMove.NORMAL,
    /** 技の接触判定 初期値あり(接触技である) */
    var contact: Boolean = true
)
