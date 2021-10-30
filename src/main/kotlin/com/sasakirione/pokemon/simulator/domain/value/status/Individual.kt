package com.sasakirione.pokemon.simulator.domain.value.status

import java.lang.IllegalArgumentException

/**
 * 個体値を担当するクラス
 */
class Individual(inIndividual: Array<Int>) {
    /** 個体値 */
    private val individual: List<Pair<StatusType, Int>>

    init {
        individual = listOf(StatusType.H to inIndividual[0],
                            StatusType.A to inIndividual[1],
                            StatusType.B to inIndividual[2],
                            StatusType.C to inIndividual[3],
                            StatusType.D to inIndividual[4],
                            StatusType.S to inIndividual[5])
    }

    /**
     * HPの個体値を取得する
     * @return HPの個体値
     */
    fun getH(): Int {
        return individual.first { pair -> pair.first == StatusType.H }.second
    }

    /**
     * 攻撃の個体値を取得する
     * @return 攻撃の個体値
     */
    fun getA(): Int {
        return individual.first { pair -> pair.first == StatusType.A }.second
    }

    /**
     * 防御の個体値を取得する
     * @return 防御の個体値
     */
    fun getB(): Int {
        return individual.first { pair -> pair.first == StatusType.B }.second
    }

    /**
     * 特攻の個体値を取得する
     * @return 特攻の個体値
     */
    fun getC(): Int {
        return individual.first { pair -> pair.first == StatusType.C }.second
    }

    /**
     * 特防の個体値を取得する
     * @return 特防の個体値
     */
    fun getD(): Int {
        return individual.first { pair -> pair.first == StatusType.D }.second
    }

    /**
     * 素早さの個体値を取得する
     * @return 素早さの個体値
     */
    fun getS(): Int {
        return individual.first { pair -> pair.first == StatusType.S }.second
    }

    /**
     * 個体値用のBuilder
     */
    class IndividualBuilder() {
        private var h = 31
        private var a = 31
        private var b = 31
        private var c = 31
        private var d = 31
        private var s = 31

        /**
         * HPにV以外にする
         */
        fun setH(h: Int): IndividualBuilder {
            checkBaseValue(h)
            this.h = h
            return this
        }

        /**
         * 攻撃をV以外にする
         */
        fun setA(a: Int): IndividualBuilder {
            checkBaseValue(a)
            this.a = a
            return this
        }

        /**
         * 防御をV以外にする
         */
        fun setB(b: Int): IndividualBuilder {
            checkBaseValue(b)
            this.b = b
            return this
        }

        /**
         * 特攻をV以外にする
         */
        fun setC(c: Int): IndividualBuilder {
            checkBaseValue(c)
            this.c = c
            return this
        }

        /**
         * 特防をV以外にする
         */
        fun setD(d: Int): IndividualBuilder {
            checkBaseValue(d)
            this.d = d
            return this
        }

        /**
         * 素早さをV以外にする
         */
        fun setS(s: Int): IndividualBuilder {
            checkBaseValue(s)
            this.s = s
            return this
        }

        /**
         * 個体値クラスを構築する
         */
        fun build(): Individual {
            return Individual(arrayOf(h, a, b, c, d, s))
        }

        /**
         * 個体値をチェックする
         * @param value 個体値の数字
         * @throws IllegalArgumentException
         */
        private fun checkBaseValue(value: Int) {
            if (value < 0 || 31 < value) {
                throw IllegalArgumentException("個体値が不正です。0から31の範囲内で入力してください")
            }
        }
    }
}