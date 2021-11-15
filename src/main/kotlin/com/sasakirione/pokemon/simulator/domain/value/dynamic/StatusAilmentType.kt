package com.sasakirione.pokemon.simulator.domain.value.dynamic

/**
 * 状態異常の列挙型
 * PARALYSIS：まひ
 * FROZEN：こおり
 * BURNED：やけど
 * POISONED：どく
 * BAD_POISONED：もうどく
 * ASLEEP：ねむり
 * CONFUSION；こんらん
 */
enum class StatusAilmentType {
    /** まひ */
    PARALYSIS,

    /** こおり */
    FROZEN,

    /** やけど */
    BURNED,

    /** どく */
    POISONED,

    /** もうどく*/
    BAD_POISONED,

    /** ねむり */
    ASLEEP,

    /** こんらん */
    CONFUSION,

    /** 状態異常なし*/
    NONE
}