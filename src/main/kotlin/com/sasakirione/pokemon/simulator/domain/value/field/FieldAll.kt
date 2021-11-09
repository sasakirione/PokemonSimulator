package com.sasakirione.pokemon.simulator.domain.value.field

/**
 * 場に対する効果を担当するクラス
 *
 * @constructor プロパティを初期化する
 */
class FieldAll {
    var field: Field = Field(FieldType.NONE)
    private val fieldEffortEtc: FieldEffortEtc = FieldEffortEtc()
    var weather: Weather = Weather(WeatherType.NONE)

}