package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect

/**
 * ポケモンのタイプ相性を担当するクラス
 */
object PokemonTypeCompatibility {
    /**
     * タイプ相性を判定する
     * 攻撃側のタイプと防御側のタイプをいれた時にタイプ相性の倍率を返します。
     * @param attack 攻撃側のタイプ
     * @param defense 防御側のタイプ
     * @return タイプ倍率
     */
    fun typeCompatibility(attack: TypeSelect, defense: TypeSelect): Double {
        var magnification = 1.0
        if (attack == TypeSelect.NORMAL) {
            if (defense == TypeSelect.ROCK || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
            if (defense == TypeSelect.GHOST) {
                magnification = 0.0
                return magnification
            }
            return magnification
        }
        if (attack == TypeSelect.FIRE) {
            if (defense == TypeSelect.GRASS || defense == TypeSelect.ICE || defense == TypeSelect.BUG || defense == TypeSelect.STEEL) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.FIRE || defense == TypeSelect.WATER || defense == TypeSelect.ROCK || defense == TypeSelect.DRAGON) {
                magnification = 0.5
                return magnification
            }
            return magnification
        }
        if (attack == TypeSelect.WATER) {
            if (defense == TypeSelect.FIRE || defense == TypeSelect.GROUND || defense == TypeSelect.ROCK) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.WATER || defense == TypeSelect.GRASS || defense == TypeSelect.DRAGON) {
                magnification = 0.5
                return magnification
            }
            return magnification
        }
        if (attack == TypeSelect.ELECTRIC) {
            if (defense == TypeSelect.WATER || defense == TypeSelect.FLYING) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.ELECTRIC || defense == TypeSelect.GRASS || defense == TypeSelect.DRAGON) {
                magnification = 0.5
                return magnification
            }
            if (defense == TypeSelect.GROUND) {
                magnification = 0.0
                return magnification
            }
            return magnification
        }
        if (attack == TypeSelect.GRASS) {
            if (defense == TypeSelect.WATER || defense == TypeSelect.GROUND || defense == TypeSelect.ROCK) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.FIRE || defense == TypeSelect.GRASS || defense == TypeSelect.POISON || defense == TypeSelect.FLYING || defense == TypeSelect.BUG || defense == TypeSelect.DRAGON || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
            return magnification
        }
        if (attack == TypeSelect.ICE) {
            if (defense == TypeSelect.GRASS || defense == TypeSelect.GROUND || defense == TypeSelect.FLYING || defense == TypeSelect.DRAGON) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.FIRE || defense == TypeSelect.WATER || defense == TypeSelect.ICE || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
            return magnification
        }
        if (attack ==TypeSelect.FIGHTING) {
            if (defense == TypeSelect.NORMAL || defense == TypeSelect.ICE || defense == TypeSelect.ROCK || defense == TypeSelect.DARK || defense == TypeSelect.STEEL) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.POISON || defense == TypeSelect.FLYING || defense == TypeSelect.PSYCHIC || defense == TypeSelect.BUG || defense == TypeSelect.FAIRLY) {
                magnification = 0.5
                return magnification
            }
        }
        if (attack == TypeSelect.POISON) {
            if (defense == TypeSelect.GRASS || defense == TypeSelect.FAIRLY) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.POISON || defense == TypeSelect.GROUND || defense == TypeSelect.ROCK || defense == TypeSelect.GHOST) {
                magnification = 0.5
                return magnification
            }
            if (defense == TypeSelect.STEEL) {
                magnification = 0.0
                return magnification
            }
        }
        if (attack == TypeSelect.GROUND) {
            if (defense == TypeSelect.FIRE || defense == TypeSelect.ELECTRIC || defense == TypeSelect.POISON || defense == TypeSelect.ROCK || defense == TypeSelect.STEEL) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.GRASS || defense == TypeSelect.BUG) {
                magnification = 0.5
                return magnification
            }
            if (defense == TypeSelect.FLYING) {
                magnification = 0.0
                return magnification
            }
        }
        if (attack == TypeSelect.FLYING) {
            if (defense == TypeSelect.GRASS || defense ==TypeSelect.FIGHTING || defense == TypeSelect.BUG) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.ELECTRIC || defense == TypeSelect.ROCK || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
        }
        if (attack == TypeSelect.PSYCHIC) {
            if (defense ==TypeSelect.FIGHTING || defense == TypeSelect.POISON) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.PSYCHIC || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
            if (defense == TypeSelect.DARK) {
                magnification = 0.0
                return magnification
            }
        }
        if (attack == TypeSelect.BUG) {
            if (defense == TypeSelect.GRASS || defense == TypeSelect.PSYCHIC || defense == TypeSelect.DARK) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.FIRE || defense ==TypeSelect.FIGHTING || defense == TypeSelect.POISON || defense == TypeSelect.FLYING || defense == TypeSelect.GHOST || defense == TypeSelect.STEEL || defense == TypeSelect.FAIRLY) {
                magnification = 0.5
                return magnification
            }
        }
        if (attack == TypeSelect.ROCK) {
            if (defense == TypeSelect.FIRE || defense == TypeSelect.FLYING || defense == TypeSelect.ICE || defense == TypeSelect.BUG) {
                magnification = 2.0
                return magnification
            }
            if (defense ==TypeSelect.FIGHTING || defense == TypeSelect.GROUND || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
        }
        if (attack == TypeSelect.GHOST) {
            if (defense == TypeSelect.PSYCHIC || defense == TypeSelect.GHOST) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.DARK) {
                magnification = 0.5
                return magnification
            }
            if (defense == TypeSelect.NORMAL) {
                magnification = 0.0
                return magnification
            }
        }
        if (attack == TypeSelect.DRAGON) {
            if (defense == TypeSelect.DRAGON) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
            if (defense == TypeSelect.FAIRLY) {
                magnification = 0.0
                return magnification
            }
        }
        if (attack == TypeSelect.DARK) {
            if (defense == TypeSelect.PSYCHIC || defense == TypeSelect.GHOST) {
                magnification = 2.0
                return magnification
            }
            if (defense ==TypeSelect.FIGHTING || defense == TypeSelect.DARK || defense == TypeSelect.FAIRLY) {
                magnification = 0.5
                return magnification
            }
        }
        if (attack == TypeSelect.STEEL) {
            if (defense == TypeSelect.ICE || defense == TypeSelect.ROCK || defense == TypeSelect.FAIRLY) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.FIRE || defense == TypeSelect.WATER || defense == TypeSelect.ELECTRIC || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
        }
        if (attack == TypeSelect.FAIRLY) {
            if (defense ==TypeSelect.FIGHTING || defense == TypeSelect.DARK || defense == TypeSelect.DRAGON) {
                magnification = 2.0
                return magnification
            }
            if (defense == TypeSelect.FIRE || defense == TypeSelect.POISON || defense == TypeSelect.STEEL) {
                magnification = 0.5
                return magnification
            }
        }
        return magnification
    }
}