package com.sasakirione.pokemon.simulator.domain.value.status

/**
 * ステータスの種類に対する列挙型
 * H: HP
 * A: 攻撃
 * B: 防御
 * C: 特攻
 * D: 特防
 * S: 素早さ
 * NONE: 選択なし
 */
enum class StatusType {
    /** HP */
    H,
    /** 攻撃 */
    A,
    /** 防御 */
    B,
    /** 特攻 */
    C,
    /** 特防 */
    D,
    /** 素早さ */
    S,
    /** 選択なし */
    NONE
}