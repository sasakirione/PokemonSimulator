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
    PARALYSIS,
    FROZEN,
    BURNED,
    POISONED,
    BAD_POISONED,
    ASLEEP,
    CONFUSION
}