package com.sasakirione.pokemon.simulator.domain.value.move

/**
 * 技の連続仕様に対する列挙型
 * NORMAL:通常攻撃、FIXED_x:x回固定攻撃、MAX_TREE：1-3回攻撃、MAX-FIVE：2-5回攻撃
 */
enum class MoveCombo {
    NORMAL,
    FIXED_TWO,
    FIXED_THREE,
    MAX_THREE,
    MAX_FIVE
}
