package com.sasakirione.pokemon.simulator.domain.value.dynamic

/**
 * 状態異常を担当するクラス
 * @param statusAilment 状態異常の種類
 */
class StatusAilment(private val statusAilment: StatusAilmentType) {
    /**
     * 攻撃に対する状態異常による補正値を返します
     *
     * @return 攻撃に対する補正倍率値
     */
    fun getAttackCorrection(): Double = when (statusAilment) {
        StatusAilmentType.BURNED -> 0.5
        else -> 1.0
    }
}