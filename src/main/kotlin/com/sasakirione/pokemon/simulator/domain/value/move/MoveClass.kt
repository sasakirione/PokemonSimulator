package com.sasakirione.pokemon.simulator.domain.value.move

/**
 * 技の種類に関する列挙型
 * 0:物理技、1:特殊技、2：自分にかかる変化技、3:相手にかかる変化技、4：場にかかる変化技
 */
enum class MoveClass {
    PHYSICS,
    SPECIAL,
    SELF_CHANGE,
    ENEMY_CHANGE,
    STADIUM_CHANGE
}
