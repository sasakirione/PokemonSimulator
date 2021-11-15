package com.sasakirione.pokemon.simulator.data

import java.io.BufferedReader
import java.util.*

/**
 * CSVの読み込み部分のオブジェクト
 *
 */
object DataGetFromCsv {
    /**
     * CSVの照会をします
     *
     * @param reader リーダー
     * @param name 技かポケモンの名前
     * @param message エラー時のメッセージ
     * @return 生のCSV配列
     */
    fun getDataFromCsv(reader: BufferedReader, name: String, message: String): Array<String> {
        val res: Array<String>
        // 対象のポケモンが見つかるまで上から順番に見ていく
        while (true) {
            // 次の行が存在しない時(最後まで見たのにポケモンがなかった時)に例外を投げる
            val row = reader.readLine() ?: throw InputMismatchException(message)
            val rowList = row.split(",").toTypedArray()

            // ポケモン名が一致したらデータを取得してループから抜ける
            if (rowList[1] == name) {
                res = rowList
                break
            }
        }
        return res
    }
}