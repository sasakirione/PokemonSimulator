package com.sasakirione.pokemon.simulator.domain.value.turn

/**
 * Turnの過程に関する列挙型
 *
 */
enum class TurnCourse {
    /**
     * ターン開始
     */
    BEFORE,

    /**
     * 1匹目と2匹目の行動の間
     */
    FIRST_MOVED,

    /**
     * ターン終了
     */
    AFTER
}