package com.sasakirione.pokemon.simulator.domain.value.status

/**
 * 種族値を担当するクラス
 * @param inBase 種族値の配列
 */
class Base(inBase: Array<Int>) {
    /** 種族値 */
    private val base: List<Pair<StatusType, Int>>

    init {
        base = listOf(
            StatusType.H to inBase[0],
            StatusType.A to inBase[1],
            StatusType.B to inBase[2],
            StatusType.C to inBase[3],
            StatusType.D to inBase[4],
            StatusType.S to inBase[5]
        )
    }

    /**
     * HPの種族値を取得する
     * @return HPの種族値
     */
    fun getH(): Int {
        return base.first { pair -> pair.first == StatusType.H }.second
    }

    /**
     * 攻撃の種族値を取得する
     * @return 攻撃の種族値
     */
    fun getA(): Int {
        return base.first { pair -> pair.first == StatusType.A }.second
    }

    /**
     * 防御の種族値を取得する
     * @return 防御の種族値
     */
    fun getB(): Int {
        return base.first { pair -> pair.first == StatusType.B }.second
    }

    /**
     * 特攻の種族値を取得する
     * @return 特攻の種族値
     */
    fun getC(): Int {
        return base.first { pair -> pair.first == StatusType.C }.second
    }

    /**
     * 特防の種族値を取得する
     * @return 特防の種族値
     */
    fun getD(): Int {
        return base.first { pair -> pair.first == StatusType.D }.second
    }

    /**
     * 素早さの種族値を取得する
     * @return 素早さの種族値
     */
    fun getS(): Int {
        return base.first { pair -> pair.first == StatusType.S }.second
    }
}