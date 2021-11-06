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
    val priority: Int = 0,
    val accuracy: Int = 100,
    val moveCombo: MoveCombo = MoveCombo.NORMAL,
    val vitalRank: VitalRank = VitalRank.ZERO,
    val multipleMove: MultipleMove = MultipleMove.NORMAL,
    val contact: Boolean = true
)
