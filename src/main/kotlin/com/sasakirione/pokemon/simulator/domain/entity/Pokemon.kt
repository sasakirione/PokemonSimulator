package com.sasakirione.pokemon.simulator.domain.entity

import com.sasakirione.pokemon.simulator.const.GoodConst
import com.sasakirione.pokemon.simulator.data.PokemonDataGet
import com.sasakirione.pokemon.simulator.data.PokemonDataGetInterface
import com.sasakirione.pokemon.simulator.domain.value.dynamic.Ability
import com.sasakirione.pokemon.simulator.domain.value.dynamic.Dynamic
import com.sasakirione.pokemon.simulator.domain.value.dynamic.Good
import com.sasakirione.pokemon.simulator.domain.value.field.FieldAll
import com.sasakirione.pokemon.simulator.domain.value.nature.Nature
import com.sasakirione.pokemon.simulator.domain.value.nature.NatureAll
import com.sasakirione.pokemon.simulator.domain.value.nature.Type
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.domain.value.status.Base
import com.sasakirione.pokemon.simulator.domain.value.status.Effort
import com.sasakirione.pokemon.simulator.domain.value.status.Individual
import com.sasakirione.pokemon.simulator.domain.value.status.Status
import com.sasakirione.pokemon.simulator.service.RealService
import kotlin.math.roundToInt

/**
 * ポケモンを表現するエンティティクラス
 *
 * @param status 能力値に関するインスタンス
 * @param dynamic 状況に関するインスタンス
 * @param natureAll 性格やタイプに関するインスタンス
 */
class Pokemon(
    private val status: Status,
    private val dynamic: Dynamic,
    private val natureAll: NatureAll,
    private val name: String
) {
    /**
     * ポケモンの名前を取得する
     *
     * @return ポケモンの名前
     */
    fun getName(): String = name

    /**
     * ポケモンの攻撃実数値を取得する
     *
     * @return 攻撃実数値
     */
    fun getRealAttack(): Int = (status.getA() * dynamic.getAttackCorrection()).roundToInt()

    /**
     * ポケモンのダメージの補正倍率値を取得する
     *
     * @param moveType 技のタイプ
     * @return ダメージの補正倍率
     */
    fun getMoveDamageCorrection(moveType: TypeSelect): Double = (dynamic.getMoveDamageCorrection(moveType))

    /**
     * ポケモンの素早さ実数値を取得する
     *
     * @return 素早さ実数値
     */
    fun getRealSpeed(): Int = (status.getS() * dynamic.getSpeedCorrection()).roundToInt()

    fun getRealSpeed(fieldAll: FieldAll): Int = (status.getS() * dynamic.getSpeedCorrection() *
            RealService.getRealSpeedCorrection(dynamic.getAbility(), fieldAll.getWhether())).roundToInt()

    /**
     * ポケモンの簡易作成を可能とするBuilderクラス
     *
     * @constructor setPokemonメソッドはコンストラクタ代わりなので必ず実行してください
     */
    class PokemonSmartBuilder {
        /** 個体値(初期値は6V)*/
        private var individual: Individual = Individual.IndividualBuilder().build()

        /** 努力値(初期値は無振り) */
        private var effort: Effort = Effort(arrayOf(0, 0, 0, 0, 0, 0))

        /** 種族値 */
        private lateinit var base: Base

        /** 特性 */
        private lateinit var ability: Ability

        /** 道具(初期値は道具なし) */
        private var good: Good = Good(GoodConst.NONE)

        /** 性格(初期値はまじめ) */
        var nature: Nature = Nature("まじめ")

        /** タイプ */
        private lateinit var type: Type

        /** ポケモンの名前 */
        private lateinit var pokemonName: String

        /**
         * ポケモンを検索します
         *
         * @param pokemonName ポケモンの名前
         * @param abilitySelect 性格の選択(1-3)
         * @return Builderインスタンス
         */
        fun setPokemon(pokemonName: String, abilitySelect: Int): PokemonSmartBuilder {
            val pokemonGet: PokemonDataGetInterface = PokemonDataGet()
            this.pokemonName = pokemonName
            val (base, type, ability) = pokemonGet.getPokemon(pokemonName, abilitySelect)
            this.base = base
            this.ability = ability
            this.type = type
            return this
        }

        /**
         * 個体値を設定します
         *
         * @param individual 個体値インスタンス
         * @return Builderインスタンス
         */
        fun setIndividual(individual: Individual): PokemonSmartBuilder {
            this.individual = individual
            return this
        }

        /**
         * 道具を設定します
         *
         * @param goodName 道具の名前
         * @return Builderインスタンス
         */
        fun setGood(goodName: String): PokemonSmartBuilder {
            this.good = Good(goodName)
            return this
        }

        /**
         * 性格を設定します
         *
         * @param natureName 性格の名前
         * @return Builderインスタンス
         */
        fun setNature(natureName: String): PokemonSmartBuilder {
            this.nature = Nature(natureName)
            return this
        }

        /**
         * 努力値を設定します
         *
         * @param effort 努力値の配列
         * @return Builderインスタンス
         */
        fun setEffort(effort: Array<Int>): PokemonSmartBuilder {
            this.effort = Effort(effort)
            return this
        }

        /**
         * Pokemonインスタンスを生成します
         *
         * @return Pokemonインスタンス
         */
        fun build(): Pokemon {
            val status = Status(individual, effort, base, nature.getNatureCorrection())
            val nature = NatureAll(nature, type)
            val dynamic = Dynamic(status.getH(), ability, good)
            return Pokemon(status, dynamic, nature, pokemonName)
        }
    }
}