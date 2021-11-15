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

/**
 * ポケモンの技のデータをcsvファイルから取得するクラス
 */
class PokemonMoveDataGet : PokemonMoveDataGetInterface {
    /**
     * プロパティファイルの読み込み
     */
    private val properties =
        Properties().apply { File("src/main/resources/path.properties").inputStream().use(this::load) }

    /**
     * 技の情報をDTOにつめて返します
     * @param name 技の名前
     * @return 技用DTO
     */
    override fun getMove(name: String): MoveDTO {
        // CSVから生データを取得
        val res = getMoveData(name)

        // 技DTOに対する必須項目の設定
        val outDTO = MoveDTO(
            moveType = setMoveType(res),
            movePower = setMovePower(res),
            moveClass = setMoveClass(res)
        )
        // 技DTOに対する必須項目以外の設定
        setEtc(outDTO, res)

        return outDTO
    }

    /**
     * 必須項目以外をDTOに設定します
     * @param outDTO 戻り値用の技DTO
     * @param res csvファイルから取得した生データ
     */
    private fun setEtc(outDTO: MoveDTO, res: Array<String>) {
        // 命中率の設定
        outDTO.accuracy = res[5].toInt()
        // 優先度の設定
        outDTO.priority = res[6].toInt()
        // 技の連続仕様の設定
        setMoveCombo(outDTO, res)
        // 技の急所ランクの設定
        setVitalRank(outDTO, res)
        // 技の複数ターン仕様の設定
        setMultipleMove(outDTO, res)
        // 技の接触非接触の設定
        // outDTO.contact
    }

    /**
     * 技の複数ターン仕様を設定します
     * @param outDTO 戻り値用の技DTO
     * @param res csvから取得した生データ
     */
    private fun setMultipleMove(outDTO: MoveDTO, res: Array<String>) {
        // 生データで設定がない場合を除外
        if (res.size < 12) {
            return
            // デフォルト値と一緒の場合も除外
        } else if (res[11] == "1") {
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

    /**
     * 技の急所ランクを設定します
     * @param outDTO 戻り値用の技DTO
     * @param res csvから取得した生データ
     */
    private fun setVitalRank(outDTO: MoveDTO, res: Array<String>) {
        // 生データで設定がない場合を除外
        if (res.size < 10) {
            return
            // デフォルト値と一緒の場合(急所に当たりやすかったり確定急所じゃない技)の場合は除外
        } else if (res[9] == "1") {
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

    /**
     * 技の連続仕様を設定します
     * @param outDTO 戻り値用の技DTO
     * @param res csvから取得した生データ
     */
    private fun setMoveCombo(outDTO: MoveDTO, res: Array<String>) {
        // 生データで設定がない場合を除外
        if (res.size < 11) {
            return
            // デフォルト値と一緒の場合(連続技じゃない技)の場合は除外
        } else if (res[10] == "1") {
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

    /**
     * 技の種類を取得します
     * @param res csvから取得した生データ
     * @return 技の種類
     */
    private fun setMoveClass(res: Array<String>): MoveClass = when {
        res[8] == "2" -> MoveClass.PHYSICS
        res[8] == "3" -> MoveClass.SPECIAL
        // 変化技は現状非対応
        else -> throw IllegalArgumentException("対応してない技です")
    }

    /**
     * 技の威力を取得します
     * @param res csvから取得した生データ
     * @return 技の威力
     */
    private fun setMovePower(res: Array<String>): Int = res[3].toInt()

    /**
     * 技のタイプを返します
     * @param res csvから取得した生データ
     * @return 技のタイプ
     */
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

    /**
     * CSVから技の生データを取得します
     * @param name 技の名前
     * @return CSVから取得した技の生データ
     */
    private fun getMoveData(name: String): Array<String> {
        val reader = Files.newBufferedReader(Paths.get(properties.getProperty("move")), Charset.forName("UTF-8"))

        return DataGetFromCsv.getDataFromCsv(reader, name, message = "技が見つかりません")
    }

}