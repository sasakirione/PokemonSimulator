package com.sasakirione.pokemon.simulator.domain.value.move

/**
 * 技の必要ターン数に対する列挙型
 */
enum class MultipleMove {
    /** 通常技 */
    NORMAL,

    /** 反動技 */
    RECOIL,

    /** ため技 */
    CHARGE,

    /** あばれる系の技 */
    THRASH
}
