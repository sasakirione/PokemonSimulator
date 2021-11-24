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
     * 2匹目の攻撃後
     */
    SECOND_MOVED,

    /**
     * ターン終了
     */
    AFTER
}