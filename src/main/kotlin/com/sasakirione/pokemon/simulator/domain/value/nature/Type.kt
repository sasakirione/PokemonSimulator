package com.sasakirione.pokemon.simulator.domain.value.nature

import com.sasakirione.pokemon.simulator.const.MoveConst
import com.sasakirione.pokemon.simulator.data.PokemonTypeCompatibility
import com.sasakirione.pokemon.simulator.domain.value.move.Move

/**
 * タイプを担当するクラス
 * @param type タイプのリスト
 */
class Type(private val type: List<TypeSelect>) {

    /**
     * タイプを増やす <BR>
     * 「ハロウィン」や「もりののろい」などタイプを増やす技などでタイプを増やすときに使います
     * @param addType 追加するタイプ
     * @return 現在のタイプに新しいタイプが追加されたインスタンス
     */
    private fun addType(addType: TypeSelect): Type {
        val addTypes = type.toMutableList()
        addTypes.add(addType)
        return Type(addTypes.toList())
    }

    /**
     * ハロウィンのタイプ処理を行います
     * @return ゴーストタイプを追加したタイプインスタンス
     */
    fun typeHalloween(): Type = addType(TypeSelect.GHOST)

    /**
     * もりののろいのタイプ処理を行います
     * @return くさタイプを追加したタイプインスタンス
     */
    fun typeMori(): Type = addType(TypeSelect.GRASS)

    /**
     * タイプを入力したタイプに変更します<BR>
     * リベロやへんげんじざいなどのタイプを変える特性、みずびたしなどの特定のタイプにタイプを変更する技で使います
     * @param changeType 変化させるタイプ
     * @return 変化させるタイプのタイプインスタンス
     */
    private fun typeChange(changeType: TypeSelect): Type = Type(listOf(changeType))

    /**
     * みずびたしのタイプ処理を行います
     * @return みず単タイプのタイプインスタンス
     */
    fun typeSoak(): Type = typeChange(TypeSelect.WATER)

    /**
     * リベロやへんげんじざいのタイプ処理を行います
     * @param move 出した技のインスタンス
     * @return 出した技のタイプのタイプインスタンス
     */
    fun typeLibero(move: Move): Type = typeChange(move.moveType)

    /**
     * タイプ相性を計算します
     * @param move 受ける技のインスタンス
     * @return 技の相性倍率
     */
    fun getTypeCompatibility(move: Move): Double = when {
        // フリーズドライ時の処理：水への補正が半減から倍になるので最終結果から4倍する
        move.name == MoveConst.FREEZE_DRY && type.contains(TypeSelect.WATER)
        -> normalTypeCompatibility(move.moveType) * 4
        // フライングプレス時の処理：格闘と飛行の両方の倍率を掛け合わせる
        move.name == MoveConst.FLYING_PRESS
        -> normalTypeCompatibility(TypeSelect.FIGHTING) * normalTypeCompatibility(TypeSelect.FLYING)
        // 通常の技の処理
        else -> normalTypeCompatibility(move.moveType)
    }

    /**
     * タイプ相性を単純に計算します
     * @param moveType 受ける技のタイプ
     * @return 技の相性倍率
     */
    private fun normalTypeCompatibility(moveType: TypeSelect): Double = type.map { type ->
        PokemonTypeCompatibility.typeCompatibility(moveType, type)
    }.reduce { acc, d -> acc * d }
}