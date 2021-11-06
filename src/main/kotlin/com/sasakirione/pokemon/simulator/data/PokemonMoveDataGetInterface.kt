package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.dto.MoveDTO

/**
 * ポケモンの技をデータベースから取ってくるクラスのインターフェース
 */
interface PokemonMoveDataGetInterface {
    fun getMove(name: String): MoveDTO
}