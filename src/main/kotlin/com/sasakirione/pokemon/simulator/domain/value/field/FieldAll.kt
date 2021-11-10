package com.sasakirione.pokemon.simulator.domain.value.field

import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * 場に対する効果を担当するクラス
 *
 * @constructor プロパティを初期化する
 */
class FieldAll {
    var field: Field = Field(FieldType.NONE)
    private val fieldEffortEtc: FieldEffortEtc = FieldEffortEtc()
    var weather: Weather = Weather(WeatherType.NONE)

    /**
     * 天気による技のタイプに対するダメージ補正を返します
     *
     * @param moveType 技のタイプ
     * @return ダメージ補正倍率
     */
    fun damageCorrectionFromMoveType(moveType: TypeSelect): Double =
        weather.damageCorrectionFromMoveType(moveType) * field.typeBoost(moveType)
}