package com.sasakirione.pokemon.simulator.domain.value.status

/**
 * 努力値を担当するクラス
 * @param inEffort 努力値の配列
 */
class Effort(inEffort: Array<Int>) {
    /** 努力値 */
    private val effort: List<Pair<StatusType, Int>>

    init {
        if (inEffort.sum() > 510) {
            throw IllegalArgumentException("努力値の合計が510を超えています")
        }
        if (inEffort.any { 252 < it }) {
            throw IllegalArgumentException("252以上努力値が振られてる箇所があります")
        }
        effort = listOf(
            StatusType.H to inEffort[0],
            StatusType.A to inEffort[1],
            StatusType.B to inEffort[2],
            StatusType.C to inEffort[3],
            StatusType.D to inEffort[4],
            StatusType.S to inEffort[5]
        )
    }

    /**
     * HPの努力値を取得する
     * @return HPの努力値
     */
    fun getH(): Int {
        return effort.first { pair -> pair.first == StatusType.H }.second
    }

    /**
     * 攻撃の努力値を取得する
     * @return 攻撃の努力値
     */
    fun getA(): Int {
        return effort.first { pair -> pair.first == StatusType.A }.second
    }

    /**
     * 防御の努力値を取得する
     * @return 防御の努力値
     */
    fun getB(): Int {
        return effort.first { pair -> pair.first == StatusType.B }.second
    }

    /**
     * 特攻の努力値を取得する
     * @return 特攻の努力値
     */
    fun getC(): Int {
        return effort.first { pair -> pair.first == StatusType.C }.second
    }

    /**
     * 特防の努力値を取得する
     * @return 特防の努力値
     */
    fun getD(): Int {
        return effort.first { pair -> pair.first == StatusType.D }.second
    }

    /**
     * 素早さの努力値を取得する
     * @return 素早さの努力値
     */
    fun getS(): Int {
        return effort.first { pair -> pair.first == StatusType.S }.second
    }
}