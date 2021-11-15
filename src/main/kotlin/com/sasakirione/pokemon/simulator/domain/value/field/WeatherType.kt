package com.sasakirione.pokemon.simulator.domain.value.field

/**
 * 天候の列挙型
 * NIHONBARE：にほんばれ
 * RAIN：あめ
 * SANDSTORM：すなあらし
 * HAIL：あられ
 * NONE：天候なし
 */
enum class WeatherType {
    /** にほんばれ */
    NIHONBARE,

    /** あめ */
    RAIN,

    /** すなあらし */
    SANDSTORM,

    /** あられ */
    HAIL,

    /** 天候なし */
    NONE
}