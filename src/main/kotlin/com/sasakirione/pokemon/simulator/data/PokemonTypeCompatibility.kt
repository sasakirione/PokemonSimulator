package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect.*

/**
 * ポケモンのタイプ相性を担当するオブジェクト
 */
object PokemonTypeCompatibility {
    /**
     * 攻撃側のタイプと防御側のタイプをいれた時にタイプ相性の倍率を返します。
     * @param attack 攻撃側のタイプ
     * @param defense 防御側のタイプ
     * @return タイプ倍率
     */
    fun typeCompatibility(attack: TypeSelect, defense: TypeSelect): Double = when (attack) {
            NORMAL -> typeCompatibilityNormal(defense)
            FIGHTING -> typeCompatibilityFighting(defense)
            FLYING -> typeCompatibilityFlying(defense)
            POISON -> typeCompatibilityPoison(defense)
            GROUND -> typeCompatibilityGround(defense)
            ROCK -> typeCompatibilityRock(defense)
            BUG -> typeCompatibilityBug(defense)
            GHOST -> typeCompatibilityGhost(defense)
            STEEL -> typeCompatibilitySteel(defense)
            FIRE -> typeCompatibilityFire(defense)
            WATER -> typeCompatibilityWater(defense)
            GRASS -> typeCompatibilityGrass(defense)
            ELECTRIC -> typeCompatibilityElectric(defense)
            PSYCHIC -> typeCompatibilityPsychic(defense)
            ICE -> typeCompatibilityIce(defense)
            DRAGON -> typeCompatibilityDragon(defense)
            DARK -> typeCompatibilityDark(defense)
            FAIRLY -> typeCompatibilityFairly(defense)
    }

    /**
     * フェアリー技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityFairly(defense: TypeSelect): Double = when (defense) {
        FIGHTING, DARK, DRAGON -> 2.0
        FIRE, POISON, STEEL -> 0.5
        else -> 1.0
    }

    /**
     * あく技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityDark(defense: TypeSelect): Double = when (defense) {
        PSYCHIC, GHOST -> 2.0
        FIGHTING, DARK, FAIRLY -> 0.5
        else -> 1.0
    }

    /**
     * ドラゴン技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityDragon(defense: TypeSelect): Double = when (defense) {
        DRAGON -> 2.0
        STEEL -> 0.5
        FAIRLY -> 0.0
        else -> 1.0
    }

    /**
     * こおり技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityIce(defense: TypeSelect): Double = when (defense) {
        GRASS, GROUND, FLYING, DRAGON -> 2.0
        FIRE, WATER, ICE, STEEL -> 0.5
        else -> 0.0
    }

    /**
     * エスパー技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityPsychic(defense: TypeSelect): Double = when (defense) {
        FIGHTING, POISON -> 2.0
        PSYCHIC, STEEL -> 0.5
        DARK -> 0.0
        else -> 1.0
    }

    /**
     * でんき技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityElectric(defense: TypeSelect): Double = when (defense) {
        WATER, FLYING -> 2.0
        ELECTRIC, GRASS, DRAGON -> 0.5
        GROUND -> 0.0
        else -> 1.0
    }

    /**
     * くさ技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityGrass(defense: TypeSelect): Double = when (defense) {
        WATER, GROUND, ROCK -> 2.0
        FIRE, GRASS, POISON, FLYING, BUG, DRAGON, STEEL -> 0.5
        else -> 1.0
    }

    /**
     * みず技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityWater(defense: TypeSelect): Double = when (defense) {
        FIRE, GROUND, ROCK -> 2.0
        WATER, GRASS, DRAGON -> 0.5
        else -> 1.0
    }

    /**
     * ほのお技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityFire(defense: TypeSelect): Double = when (defense) {
        GRASS, ICE, BUG, STEEL -> 2.0
        FIRE, WATER, ROCK, DRAGON -> 0.5
        else -> 1.0
    }

    /**
     * はがね技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilitySteel(defense: TypeSelect): Double = when (defense) {
        ICE, ROCK, FAIRLY -> 2.0
        FIRE, WATER, ELECTRIC, STEEL -> 0.5
        else -> 1.0
    }

    /**
     * ゴースト技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityGhost(defense: TypeSelect): Double = when (defense) {
        PSYCHIC, GHOST -> 2.0
        DARK -> 0.5
        NORMAL -> 0.0
        else -> 1.0
    }

    /**
     * むし技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityBug(defense: TypeSelect): Double = when (defense) {
        GRASS, PSYCHIC, DARK -> 2.0
        FIRE, FIGHTING, POISON, FLYING, GHOST, STEEL, FAIRLY -> 0.5
        else -> 1.0
    }

    /**
     * いわ技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityRock(defense: TypeSelect): Double = when (defense) {
        FIRE, FLYING, ICE, BUG -> 2.0
        FIGHTING, GROUND, STEEL -> 0.5
        else -> 1.0
    }

    /**
     * じめん技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityGround(defense: TypeSelect): Double = when (defense) {
        FIRE, ELECTRIC, POISON, ROCK, STEEL -> 2.0
        GRASS, BUG -> 0.5
        FLYING -> 0.0
        else -> 1.0
    }

    /**
     * どく技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityPoison(defense: TypeSelect): Double = when (defense) {
        GRASS, FAIRLY -> 2.0
        POISON, GROUND, ROCK, GHOST -> 0.5
        STEEL -> 0.0
        else -> 1.0
    }

    /**
     * ひこう技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityFlying(defense: TypeSelect): Double = when (defense) {
        GRASS, FIGHTING, BUG -> 2.0
        ELECTRIC, ROCK, STEEL -> 0.5
        else -> 1.0
    }

    /**
     * かくとう技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityFighting(defense: TypeSelect): Double = when (defense) {
        NORMAL, ICE, ROCK, DARK, STEEL -> 2.0
        POISON, FLYING, PSYCHIC, BUG, FAIRLY -> 0.5
        else -> 1.0
    }

    /**
     * ノーマル技に対するタイプ相性の倍率
     * @param defense 受けるタイプ
     * @return タイプ相性の倍率
     */
    private fun typeCompatibilityNormal(defense: TypeSelect): Double = when (defense) {
        ROCK, STEEL -> 0.5
        GHOST -> 0.0
        else -> 1.0
    }
}
