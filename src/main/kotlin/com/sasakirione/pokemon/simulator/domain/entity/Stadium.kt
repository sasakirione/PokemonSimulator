package com.sasakirione.pokemon.simulator.domain.entity

import com.sasakirione.pokemon.simulator.domain.value.field.FieldAll

class Stadium(val sideA: Building, val sideB: Building) {
    val field: FieldAll = FieldAll()
}