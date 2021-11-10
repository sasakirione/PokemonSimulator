package com.sasakirione.pokemon.simulator.domain.value.field

import com.sasakirione.pokemon.simulator.const.CalculationConst
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * 場の天気を担当するクラス
 * @param weather 天気の種類
 */
class Weather(private val weather: WeatherType) {
    /**
     * 天気による技のタイプに対するダメージ補正を返します
     *
     * @param moveType 技のタイプ
     * @return ダメージ補正倍率
     */
    fun damageCorrectionFromMoveType (moveType: TypeSelect): Double = when {
        weather == WeatherType.NIHONBARE && moveType == TypeSelect.FIRE
            -> CalculationConst.ONE_POINT_FIVE
        weather == WeatherType.NIHONBARE && moveType == TypeSelect.WATER
            -> CalculationConst.HALF
        weather == WeatherType.RAIN && moveType == TypeSelect.WATER
        -> CalculationConst.ONE_POINT_FIVE
        weather == WeatherType.RAIN && moveType == TypeSelect.FIRE
        -> CalculationConst.HALF
        else -> 1.0
    }
}