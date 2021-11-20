package com.sasakirione.pokemon.simulator.domain.value.field

import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * 場に対する効果を担当するクラス
 *
 * @constructor プロパティを初期化する
 */
class FieldAll {
    /** フィールド */
    private var field: Field = Field(FieldType.NONE)

    /** その他の場にかかる効果 */
    private val fieldEffortEtc: FieldEffortEtc = FieldEffortEtc()

    /** 天気 */
    private var weather: Weather = Weather(WeatherType.NONE)

    /**
     * 場による技のタイプに対するダメージ補正を返します
     *
     * @param moveType 技のタイプ
     * @return ダメージ補正倍率
     */
    fun damageCorrectionFromMoveType(moveType: TypeSelect): Double =
        weather.damageCorrectionFromMoveType(moveType) * field.damageCorrectionFromMoveType(moveType)

    /**
     * 場による技のタイプに対するダメージ補正を返します(ふゆう、ひこうタイプ用)
     *
     * @param moveType 技のタイプ
     * @return ダメージ補正倍率
     */
    fun damageCorrectionFromMoveTypeOfFly(moveType: TypeSelect): Double =
        weather.damageCorrectionFromMoveType(moveType)

    fun getWhether(): Weather = this.weather
}