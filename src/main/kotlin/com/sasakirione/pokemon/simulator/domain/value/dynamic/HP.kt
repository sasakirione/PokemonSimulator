package com.sasakirione.pokemon.simulator.domain.value.dynamic

import kotlin.math.floor
import kotlin.math.max

class HP(maxHP: Int) {
    /** 現在のHP */
    var currentHP: Int = maxHP
        private set

    /**
     *  HPを減らす処理を行う
     *  @param amount HPの減らす量
     */
    fun decreaseHP(amount: Int) {
        currentHP = max(0, currentHP - amount)
    }

    /**
     * HPを半分にする
     */
    fun makeHPHalf() {
        val amount = floor(currentHP / 2.0).toInt()
        decreaseHP(amount)
    }
}