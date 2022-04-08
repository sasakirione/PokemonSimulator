package com.sasakirione.pokemon.simulator.utility

object Logging {
    private var log = mutableListOf<String>()

    fun getAllLog() {
        log.forEach{ s -> println(s) }
    }

    fun getLatestLog() {
        println( log.last() )
    }

    fun putPokemon(pokemonName: String, trainerName: String) {
        log.add("$trainerName は $pokemonName を繰り出した！")
    }

    fun attack(pokemonName: String, moveName: String) {
        log.add("$pokemonName の $moveName のこうげきだ！")
    }

    fun typeMagnification(modification: Double) {
        val str = when {
            modification == 0.0 -> "こうかがないようだ"
            modification < 1 -> "こうかいまひとつだ！"
            modification > 1 -> "こうかばつぐんだ！"
            else -> return
        }
        log.add(str)
    }
}