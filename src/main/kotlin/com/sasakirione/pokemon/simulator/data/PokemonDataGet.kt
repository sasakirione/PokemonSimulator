package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.data.DataGetFromCsv.getDataFromCsv
import com.sasakirione.pokemon.simulator.domain.value.dynamic.Ability
import com.sasakirione.pokemon.simulator.domain.value.nature.Type
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.domain.value.status.Base
import java.io.BufferedReader
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 * ポケモンのデータをcsvファイルから取得するクラス
 *
 * @constructor プロパティファイルの読み込み
 */
class PokemonDataGet: PokemonDataGetInterface {
    /**
     * プロパティファイルの読み込み
     */
    private val properties = Properties().apply{ File("src/main/resources/path.properties").inputStream().use(this::load)}

    /**
     * ポケモンクラス生成に必要なデータを返します
     *
     * @param pokemonName ポケモンの名前
     * @param abilitySelect 特性の選択(1-3)
     * @return 個体値インスタンス、タイプインスタンス、特性インスタンス
     */
    override fun getPokemon(pokemonName: String, abilitySelect: Int): Triple<Base, Type, Ability> {
        val res = getPokemonData(pokemonName)
        val base = getBase(res)
        val type = getType(res)
        val ability = Ability(res[abilitySelect+3])
        return Triple(base, type, ability)
    }

    /**
     * タイプインスタンスを生成します
     *
     * @param res csvを配列に変換したファイル
     * @return タイプインスタンス
     */
    private fun getType(res: Array<String>): Type {
        val type1 = res[2]
        val type2 = res[3]
        return if (type2 == "") {
            Type(listOf(getTypeSelect(type1)))
        } else {
            Type(listOf(getTypeSelect(type1), getTypeSelect(type2)))
        }
    }

    /**
     * csvの情報をタイプの列挙型に変換します
     *
     * @param type csvから取得したタイプの名前
     * @return タイプの列挙型
     */
    private fun getTypeSelect(type: String): TypeSelect = when (type) {
        "ノーマル" -> TypeSelect.NORMAL
        "かくとう" -> TypeSelect.FIGHTING
        "ひこう" -> TypeSelect.FLYING
        "どく" -> TypeSelect.POISON
        "じめん" -> TypeSelect.GROUND
        "いわ" -> TypeSelect.ROCK
        "むし" -> TypeSelect.BUG
        "ゴースト" -> TypeSelect.GHOST
        "はがね" -> TypeSelect.STEEL
        "ほのお" -> TypeSelect.FIRE
        "みず" -> TypeSelect.WATER
        "くさ" -> TypeSelect.GRASS
        "でんき" -> TypeSelect.ELECTRIC
        "エスパー" -> TypeSelect.PSYCHIC
        "こおり" -> TypeSelect.ICE
        "ドラゴン" -> TypeSelect.DRAGON
        "あく" -> TypeSelect.DARK
        "フェアリー" -> TypeSelect.FAIRLY
        else -> throw IllegalArgumentException("不正なタイプです")
    }

    /**
     * 種族値インスタンスを生成します
     *
     * @param res csvを配列に変換したファイル
     * @return 種族値インスタンス
     */
    private fun getBase(res: Array<String>): Base = Base(
        arrayOf(res[7].toInt(), res[8].toInt(), res[9].toInt(), res[10].toInt(), res[11].toInt(), res[12].toInt())
    )

    /**
     * csvからポケモンのデータを配列で取得します
     *
     * @param pokemonName ポケモンの名前
     * @return 該当するcsvの配列データ
     */
    private fun getPokemonData(pokemonName: String): Array<String> {
        val reader =
            Files.newBufferedReader(Paths.get(properties.getProperty("pokemon")), Charset.forName("windows-31j"))

        return getDataFromCsv(reader, pokemonName, message = "ポケモンが見つかりません")
    }
}