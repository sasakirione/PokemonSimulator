package com.sasakirione.pokemon.simulator.service

import com.sasakirione.pokemon.simulator.domain.value.dynamic.Ability
import com.sasakirione.pokemon.simulator.domain.value.field.Weather

object RealService {
    /**
     * 複数の値が関わる素早さ補正倍率値を返します
     *
     * @param ability 特性のインスタンス
     * @param weather 天気のインスタンス
     * @return 素早さ補正倍率
     */
    fun getRealSpeedCorrection(ability: Ability, weather: Weather): Double = when {
        ability.isSuiSui() && weather.isSuiSUi()
        -> 2.0
        else -> 1.0
    }
}