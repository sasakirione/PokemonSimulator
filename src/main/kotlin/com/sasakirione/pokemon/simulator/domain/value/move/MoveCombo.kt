package com.sasakirione.pokemon.simulator.domain.value.move

/**
 * 技の連続仕様に対する列挙型
 * NORMAL:通常攻撃、FIXED_x:x回固定攻撃、MAX_TREE：1-3回攻撃、MAX-FIVE：2-5回攻撃
 */
enum class MoveCombo {
    /** 通常攻撃技*/
    NORMAL,
    /** 2回固定攻撃技 */
    FIXED_TWO,
    /** 3回固定攻撃技 */
    FIXED_THREE,
    /** 1-3回攻撃技 */
    MAX_THREE,
    /** 2-5回攻撃技 */
    MAX_FIVE
}
