package com.sasakirione.pokemon.simulator.data

import com.sasakirione.pokemon.simulator.domain.value.move.MoveClass
import com.sasakirione.pokemon.simulator.domain.value.move.MoveCombo
import com.sasakirione.pokemon.simulator.domain.value.move.MultipleMove
import com.sasakirione.pokemon.simulator.domain.value.move.VitalRank
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.dto.MoveDTO
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


class PokemonMoveDataGet: PokemonMoveDataGetInterface {
    private val properties = Properties().apply{File("src/main/resources/path.properties").inputStream().use(this::load)}

    override fun getMove(name: String): MoveDTO{
        val res = getMoveData(name)
        val outDTO = MoveDTO(
            moveType = setMoveType(res),
            movePower = setMovePower(res),
            moveClass = setMoveClass(res)
        )
        setEtc(outDTO, res)
        return outDTO
    }

    private fun setEtc(outDTO: MoveDTO, res: Array<String>) {
        outDTO.accuracy = res[5].toInt()
        outDTO.priority = res[6].toInt()
        setMoveCombo(outDTO, res)
        setVitalRank(outDTO, res)
        setMultipleMove(outDTO, res)
        // outDTO.contact
    }

    private fun setMultipleMove(outDTO: MoveDTO, res: Array<String>) {
        if (res.size < 12) {
            return
        } else if (res[11] == "1"){
            return
        } else {
            outDTO.multipleMove = when (res[11]) {
                "2" -> MultipleMove.RECOIL
                "3" -> MultipleMove.CHARGE
                "4" -> MultipleMove.THRASH
                else -> throw IllegalArgumentException("技のターン仕様の不正値です")
            }
        }
    }

    private fun setVitalRank(outDTO: MoveDTO, res: Array<String>) {
        if (res.size < 10) {
            return
        } else if (res[9] == "1"){
            return
        } else {
            outDTO.vitalRank = when (res[9]) {
                "1" -> VitalRank.ONE
                "2" -> VitalRank.TWO
                "3" -> VitalRank.THREE
                else -> throw IllegalArgumentException("急所ランクの不正値です")
            }
        }
    }

    private fun setMoveCombo(outDTO: MoveDTO, res: Array<String>) {
        if (res.size < 11) {
            return
        } else if (res[10] == "1"){
            return
        } else {
            outDTO.moveCombo = when (res[10]) {
                "3" -> MoveCombo.FIXED_THREE
                "2" -> MoveCombo.FIXED_TWO
                "30" -> MoveCombo.MAX_THREE
                "50" -> MoveCombo.MAX_FIVE
                else -> throw IllegalArgumentException("技の連続仕様の不正値です")
            }
        }
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