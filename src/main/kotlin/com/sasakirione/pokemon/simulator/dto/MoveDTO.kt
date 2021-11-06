package com.sasakirione.pokemon.simulator.dto

import com.sasakirione.pokemon.simulator.domain.value.move.MoveClass
import com.sasakirione.pokemon.simulator.domain.value.move.MoveCombo
import com.sasakirione.pokemon.simulator.domain.value.move.MultipleMove
import com.sasakirione.pokemon.simulator.domain.value.move.VitalRank
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

data class MoveDTO(
    val moveType: TypeSelect,
    val movePower: Int,
    val moveClass: MoveClass,
    var priority: Int = 0,
    var accuracy: Int = 100,
    var moveCombo: MoveCombo = MoveCombo.NORMAL,
    var vitalRank: VitalRank = VitalRank.ZERO,
    var multipleMove: MultipleMove = MultipleMove.NORMAL,
    var contact: Boolean = true
)
