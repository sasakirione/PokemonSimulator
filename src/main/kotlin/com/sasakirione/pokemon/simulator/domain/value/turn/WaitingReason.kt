package com.sasakirione.pokemon.simulator.domain.value.turn

/**
 * 処理待ちの理由に関する列挙型
 *
 */
enum class WaitingReason {
    /**
     * 指示待ちなし
     */
    NONE,

    /**
     * A側のポケモンの交代待ち
     */
    POKEMON_CHANGE_SIDE_A,

    /**
     * B側のポケモンの交代待ち
     */
    POKEMON_CHANGE_SIDE_B
}
