package com.sasakirione.pokemon.simulator.domain.value.move

/**
 * 技の必要ターン数に対する列挙型
 * NORMAL：通常技、RECOIL：反動技、CHARGE：ため技、THRASH：あばれる系の技
 */
enum class MultipleMove {
    NORMAL,
    RECOIL,
    CHARGE,
    THRASH
}
