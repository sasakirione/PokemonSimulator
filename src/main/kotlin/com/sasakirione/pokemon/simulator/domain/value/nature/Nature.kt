package com.sasakirione.pokemon.simulator.domain.value.nature

import com.sasakirione.pokemon.simulator.const.NatureConst
import com.sasakirione.pokemon.simulator.domain.value.status.StatusCorrection
import com.sasakirione.pokemon.simulator.domain.value.status.StatusType
import java.lang.IllegalArgumentException

/**
 * 性格を担当するクラス
 * @param nature 性格の名前
 */
class Nature(private val nature: String) {

    init {
        checkNature(nature)
    }

    /**
     * 実在する性格かチェックを行う行う
     * @throw IllegalArgumentException
     */
    private fun checkNature(natureCandidate: String) {
        if (!NatureConst.NATURE.contains(natureCandidate)) {
            throw IllegalArgumentException("存在しない性格です")
        }
    }

    /**
     * 性格により上昇補正がかかるステータスを返します
     * @return 上昇する能力値のStatusTypeクラス
     */
    private fun plusNature(): StatusType = when(nature) {
        "さみしがり", "いじっぱり", "やんちゃ", "ゆうかん" -> StatusType.A
        "ずぶとい", "わんぱく", "のうてんき", "のんき" -> StatusType.B
        "ひかえめ", "おっとり", "うっかりや", "れいせい" -> StatusType.C
        "おだやか", "おとなしい", "しんちょう", "なまいき" -> StatusType.D
        "おくびょう", "ようき", "せっかち", "むじゃき" -> StatusType.S
        else -> StatusType.NONE
    }

    /**
     * 性格により下降補正がかかるステータスを返します
     * @return 下降する能力値のStatusTypeクラス
     */
    private fun minusNature(): StatusType = when(nature) {
        "おくびょう", "ひかえめ", "ずぶとい", "おだやか" -> StatusType.A
        "さみしがり", "おっとり", "おとなしい", "せっかち" -> StatusType.B
        "ようき", "いじっぱり", "わんぱく", "しんちょう" -> StatusType.C
        "やんちゃ", "のうてんき", "うっかりや", "むじゃき" -> StatusType.D
        "ゆうかん", "のんき", "れいせい", "なまいき" -> StatusType.S
        else -> StatusType.NONE
    }

    /**
     * 性格補正を取得する
     * @return 性格補正
     */
    fun getNatureCorrection(): List<Pair<StatusCorrection ,StatusType>> {
        return listOf(StatusCorrection.PLUS to plusNature(), StatusCorrection.MINUS to minusNature())
    }

}