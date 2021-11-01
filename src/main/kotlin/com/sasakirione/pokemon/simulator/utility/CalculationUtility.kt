package com.sasakirione.pokemon.simulator.utility

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * 計算に関するUtilityオブジェクト
 */
object CalculationUtility {
    /**
     * 五捨五超入の計算を行う
     * @param i 五捨五超入を行いたい値
     * @return 行った値
     */
    fun fiveOutOverFiveIn(i: Double): Int {
        val bigDecimal = BigDecimal(i.toString())
        val resBD = bigDecimal.setScale(0, RoundingMode.HALF_DOWN)
        return resBD.toDouble().toInt()
    }
}