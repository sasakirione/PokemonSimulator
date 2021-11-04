package com.sasakirione.pokemon.simulator.domain.value.nature

import com.sasakirione.pokemon.simulator.data.PokemonTypeCompatibility

/**
 * タイプを担当するクラス
 * @param type タイプのリスト
 */
class Type(private val type: List<TypeSelect>) {

    /**
     * タイプを増やす <BR>
     * 「ハロウィン」や「もりののろい」などタイプを増やす技などでタイプを増やすときに使います
     * @param addType 追加するタイプ
     * @return 現在のタイプに新しいタイプが追加されたタイプオブジェクト
     */
    private fun addType(addType: TypeSelect): Type {
        val addTypes = type.toMutableList()
        addTypes.add(addType)
        return Type(addTypes.toList())
    }

    /**
     * ハロウィンのタイプ処理を行います
     * @return ゴーストタイプを追加したタイプオブジェクト
     */
    fun typeHalloween(): Type = addType(TypeSelect.GHOST)

    /**
     * もりののろいのタイプ処理を行います
     * @return くさタイプを追加したタイプオブジェクト
     */
    fun typeMori(): Type = addType(TypeSelect.GRASS)

    /**
     * タイプを入力したタイプに変更します<BR>
     * リベロやへんげんじざいなどのタイプを変える特性、みずびたしなどの特定のタイプにタイプを変更する技で使います
     * @param changeType 変化させるタイプ
     * @return 変化させるタイプのタイプオブジェクト
     */
    private fun typeChange(changeType: TypeSelect): Type = Type(listOf(changeType))

    /**
     * みずびたしのタイプ処理を行います
     * @return みず単タイプのタイプオブジェクト
     */
    fun typeSoak(): Type = typeChange(TypeSelect.WATER)

    /**
     * リベロやへんげんじざいのタイプ処理を行います
     * @param moveType 出した技のタイプ
     * @return 出した技のタイプのタイプオブジェクト
     */
    fun typeLibero(moveType: TypeSelect): Type = typeChange(moveType)

    /**
     * タイプ相性を計算します
     * @param moveType 受ける技のタイプ
     * @return 技の相性倍率
     */
    fun getTypeCompatibility(moveType: TypeSelect): Double = type.map {
            type -> PokemonTypeCompatibility.typeCompatibility(moveType, type)
        }.reduce { acc, d -> acc * d }
}