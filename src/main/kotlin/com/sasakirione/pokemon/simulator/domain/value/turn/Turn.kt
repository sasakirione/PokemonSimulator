package com.sasakirione.pokemon.simulator.domain.value.turn

import com.sasakirione.pokemon.simulator.domain.entity.Pokemon
import com.sasakirione.pokemon.simulator.domain.value.move.Move
import com.sasakirione.pokemon.simulator.domain.value.turn.TurnCourse.*
import kotlin.math.roundToInt

/**
 * ターンを表すクラス
 *
 * @constructor ターンの経過を攻撃前で初期化
 *
 * @param sideA
 * @param sideB
 */
class Turn(private val sideA: Move, private val sideB: Move) {
    /**
     * ターンの経過
     */
    var turnCourse = BEFORE

    private var moveOrder: Int

    var existsProcessingWaiting:Boolean = true

    init {
        val priority = comparePriority()
        moveOrder = if (priority == 0) {
            compareSpeed(sideA.pokemon, sideB.pokemon)
        } else {
            priority
        }
    }

    /**
     * 処理をすすめる
     *
     * @return
     */
    fun go(): Turn {
        if (!existsProcessingWaiting) {
            return this
        }
        when (turnCourse) {
            BEFORE -> when (moveOrder) {
                1 -> {
                    act(sideA, sideB)
                    turnCourse = FIRST_MOVED
                }
                -1 -> {
                    act(sideB, sideA)
                    turnCourse = FIRST_MOVED
                }
            }
            FIRST_MOVED -> when (moveOrder) {
                1 -> act(sideB, sideA)
                -1 -> act(sideA, sideB)
            }
            SECOND_MOVED -> return this
            AFTER -> return this
        }
        return this
    }

    private fun act(side: Move, notSide: Move) {
        notSide.pokemon.getDamage(side.getDamage())
    }

    /**
     * 技の優先度を判定する
     *
     * @return Aの技の方が優先度が高ければ1、Bの技の方が優先度が高ければ-1、それ以外は0
     */
    private fun comparePriority(): Int = when {
        sideB.priority < sideA.priority -> 1
        sideA.priority < sideB.priority -> -1
        else -> 0
    }

    companion object {
        /**
         * 素早さを比較する
         *
         * @param sideA A側のポケモン
         * @param sideB B側のポケモン
         * @return A側の方がSが早ければ1、B側の方が早ければ-1、同速はランダム
         */
        fun compareSpeed(sideA: Pokemon, sideB: Pokemon): Int {
            val speedA = sideA.getRealSpeed()
            val speedB = sideB.getRealSpeed()
            return when {
                speedB < speedA -> 1
                speedA < speedB -> -1
                else -> equalsSpeed()
            }
        }

        /**
         * 同速用の乱数
         *
         * @return 50% 50%で1か-1を返す
         */
        private fun equalsSpeed(): Int = when (Math.random().roundToInt()) {
            1 -> 1
            0 -> -1
            else -> 1
        }
    }
}