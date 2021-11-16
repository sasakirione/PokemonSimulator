package com.sasakirione.pokemon.simulator.domain.entity

/**
 * 構築を担当するエンティティ
 *
 * @property pokemonArray ポケモンの配列
 */
class Building(private val pokemonArray: Array<Pokemon>) {
    var pokemonElection: Array<Pokemon> = arrayOf()
        private set
    var currentPokemon: Int = 0

    /**
     * 選出を設定します
     *
     * @param i 1匹目のポケモン
     * @param j 2匹目のポケモン
     * @param k 3匹目のポケモン
     */
    fun setElection(i:Int, j:Int, k:Int) {
        this.pokemonElection = arrayOf(pokemonArray[i], pokemonArray[j], pokemonArray[k])
    }

    /**
     * 構築を取得します
     *
     * @return ポケモンの名前の配列
     */
    fun getBuilding(): Array<String> = pokemonArray.map { pokemon -> pokemon.getName() }.toTypedArray()
}