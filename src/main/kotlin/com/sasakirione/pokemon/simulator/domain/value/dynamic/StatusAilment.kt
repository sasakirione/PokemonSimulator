package com.sasakirione.pokemon.simulator.domain.value.dynamic

/**
 * 状態異常を担当するクラス
 * @param statusAilment 状態異常の種類
 */
class StatusAilment(private val statusAilment: StatusAilmentType) {
    /**
     * 状態異常による攻撃に対する補正倍率を返します
     *
     * @return 攻撃に対する補正倍率値
     */
    fun getAttackCorrection(): Double = when (statusAilment) {
        StatusAilmentType.BURNED -> 0.5
        else -> 1.0
    }

    /**
     * 状態異常による素早さに対する補正倍率を返します
     *
     * @return 素早さに対する補正倍率値
     */
    fun getSpeedCorrection(): Double = when (statusAilment) {
        StatusAilmentType.PARALYSIS -> 0.5
        else -> 1.0
    }

    /**
     * 状態異常による技の成功の可否
     *
     * @return 技が成功するならTrue
     */
    fun isMoveSuccess(): Boolean = when (statusAilment) {
        StatusAilmentType.PARALYSIS -> isMoveSuccessPAR()
        else -> true
    }

    /**
     * まひ状態の時の技の成功の可否を判定するメソッド
     *
     * @return 技が成功するならtrue
     */
    private fun isMoveSuccessPAR(): Boolean = (0..3).random() != 0
}