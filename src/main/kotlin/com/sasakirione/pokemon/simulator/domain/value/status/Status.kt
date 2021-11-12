package com.sasakirione.pokemon.simulator.domain.value.status

import kotlin.math.floor

/**
 * ポケモンの実数値を担当するクラス
 * @param individual 個体値
 * @param effort 努力値
 * @param base 種族値
 * @param natureCorrection 性格補正
 */
class Status(individual: Individual, effort: Effort, base: Base, natureCorrection: List<Pair<StatusCorrection, StatusType>>) {
    /** 補正なし実数値 */
    private val realSource: List<Pair<StatusType, Int>>
    /** 実数値 */
    private var real: MutableList<Pair<StatusType, Int>>

    init {
        val realSourceWork = listOf(
            StatusType.H to realCalculationHP(base.getH(), individual.getH(), effort.getH()),
            StatusType.A to realCalculationEtc(base.getA(), individual.getA(), effort.getA()),
            StatusType.B to realCalculationEtc(base.getB(), individual.getB(), effort.getB()),
            StatusType.C to realCalculationEtc(base.getC(), individual.getC(), effort.getC()),
            StatusType.D to realCalculationEtc(base.getD(), individual.getD(), effort.getD()),
            StatusType.S to realCalculationEtc(base.getS(), individual.getS(), effort.getS())
        )
        realSource = calculateNatureCorrection(realSourceWork, natureCorrection)
        real = realSource.toMutableList()
    }

    /**
     * 性格補正を計算します
     * @param realSourceWork 性格補正前実数値
     * @param natureCorrection 性格補正
     * @return 性格補正後実数値
     */
    private fun calculateNatureCorrection(
        realSourceWork: List<Pair<StatusType, Int>>,
        natureCorrection: List<Pair<StatusCorrection, StatusType>>
    ): List<Pair<StatusType, Int>> {
        // まじめ系の性格の場合はそのまま返す
        if (natureCorrection[0].second == StatusType.NONE) {
            return realSourceWork
        }

        val plus = natureCorrection.first { pair -> pair.first == StatusCorrection.PLUS }
        val minus = natureCorrection.first { pair -> pair.first == StatusCorrection.MINUS }
        return realSourceWork.map {
            when(it.first) {
                plus.second -> it.first to floor(it.second * 1.1).toInt()
                minus.second -> it.first to floor(it.second * 0.9).toInt()
                else -> it.first to it.second
            }
        }
    }

    /**
     * HPの実数値の計算
     * @param base 種族値
     * @param individual 個体値
     * @param effort 努力値
     */
    private fun realCalculationHP(base: Int, individual: Int, effort: Int): Int {
        return floor((base * 2.0 + individual + floor(effort / 4.0)) * (50.0 / 100.0) + 50 + 10).toInt()
    }

    /**
     * HP以外の実数値の計算
     * @param base 種族値
     * @param individual 個体値
     * @param effort 努力値
     */
    private fun realCalculationEtc(base: Int, individual: Int, effort: Int): Int {
        return floor((base * 2.0 + individual + floor(effort / 4.0)) * (50.0 / 100.0) + 5).toInt()
    }

    /**
     * HP実数値を取得する
     *
     * @return HP実数値
     */
    fun getH(): Int = real.first { pair -> pair.first == StatusType.H }.second

    /**
     * 攻撃実数値を取得する
     *
     * @return 攻撃実数値
     */
    fun getA(): Int = real.first { pair -> pair.first == StatusType.A }.second

    /**
     * 防御実数値を取得する
     *
     * @return 防御実数値
     */
    fun getB(): Int = real.first {pair -> pair.first == StatusType.B }.second
}