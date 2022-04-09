package com.sasakirione.pokemon.simulator.utility

object Logging {
    private var log = mutableListOf<String>()

    fun getAllLog() {
        log.forEach{ s -> println(s) }
    }

    fun getLatestLog() {
        println( log.last() )
    }

    fun add(message: String) {
        log.add(message)
    }

    fun putPokemon(pokemonName: String, trainerName: String) {
        add("$trainerName は $pokemonName を繰り出した！")
    }

    fun attack(pokemonName: String, moveName: String) {
        add("$pokemonName の $moveName のこうげきだ！")
    }

    fun typeMagnification(modification: Double) {
        val str = when {
            modification == 0.0 -> "こうかがないようだ"
            modification < 1 -> "こうかいまひとつだ！"
            modification > 1 -> "こうかばつぐんだ！"
            else -> return
        }
        add(str)
    }
}