package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.domain.value.dynamic.Ability
import com.sasakirione.pokemon.simulator.domain.value.nature.Type
import com.sasakirione.pokemon.simulator.domain.value.status.Base


interface PokemonDataGetInterface {
    fun dataGet(pokemonName: String, abilitySelect: Int): Triple<Base, Type, Ability>
}