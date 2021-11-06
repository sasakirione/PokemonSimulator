package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.domain.value.move.MoveClass
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.dto.MoveDTO
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


class PokemonMoveDataGet: PokemonMoveDataGetInterface {
    private val properties = Properties().apply{File("src/main/resources/path.properties").inputStream().use(this::load)}

    override fun getMove(name: String): MoveDTO{
        val res = getMoveData(name)
        val outDTO= MoveDTO(
            moveType = setMoveType(res),
            movePower = setMovePower(res),
            moveClass = setMoveClass(res)
        )
        return outDTO
    }

    private fun setMoveClass(res: Array<String>): MoveClass = when {
        res[8] == "2" -> MoveClass.PHYSICS
        res[8] == "3" -> MoveClass.SPECIAL
        else -> throw IllegalArgumentException("対応してない技です")
    }

    private fun setMovePower(res: Array<String>): Int = res[3].toInt()

    private fun setMoveType(res: Array<String>): TypeSelect = when (res[2].toInt()) {
        1 -> TypeSelect.NORMAL
        2 -> TypeSelect.FIGHTING
        3 -> TypeSelect.FLYING
        4 -> TypeSelect.POISON
        5 -> TypeSelect.GROUND
        6 -> TypeSelect.ROCK
        7 -> TypeSelect.BUG
        8 -> TypeSelect.GHOST
        9 -> TypeSelect.STEEL
        10 -> TypeSelect.FIRE
        11 -> TypeSelect.WATER
        12 -> TypeSelect.GRASS
        13 -> TypeSelect.ELECTRIC
        14 -> TypeSelect.PSYCHIC
        15 -> TypeSelect.ICE
        16 -> TypeSelect.DRAGON
        17 -> TypeSelect.DARK
        else -> throw IllegalArgumentException("技のタイプが不正です")
    }

    private fun getMoveData(name: String): Array<String> {
        val reader = Files.newBufferedReader(Paths.get(properties.getProperty("move")), Charset.forName("UTF-8"))
        val res: Array<String>
        while (true) {
            val row = reader.readLine() ?: throw InputMismatchException("技がありません")
            val rowList = row.split(",").toTypedArray()
            if (rowList[1] == name) {
                res = rowList
                break
            }
        }
        return res
    }

}