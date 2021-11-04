import com.sasakirione.pokemon.simulator.const.CalculationConst
import com.sasakirione.pokemon.simulator.domain.value.dynamic.HP
import com.sasakirione.pokemon.simulator.domain.value.field.Field
import com.sasakirione.pokemon.simulator.domain.value.field.FieldType
import com.sasakirione.pokemon.simulator.domain.value.nature.Type
import com.sasakirione.pokemon.simulator.domain.value.nature.TypeSelect
import com.sasakirione.pokemon.simulator.domain.value.status.Effort
import com.sasakirione.pokemon.simulator.domain.value.status.Individual
import org.junit.jupiter.api.DisplayName
import kotlin.test.Asserter
import kotlin.test.Test
import kotlin.test.assertFails

class PokemonTest {
    @Test
    @DisplayName("努力値担当クラスのテスト")
    fun test001() {
        val effort1 = Effort(arrayOf(252, 0, 0, 252, 0, 4))
        println(effort1.getH())
        assertFails { Effort(arrayOf(252, 252, 252, 252, 252, 252)) }
        assertFails { Effort(arrayOf(500, 0, 0, 0, 0, 10)) }
    }

    @Test
    @DisplayName("個体値を担当するクラスのテスト")
    fun test002() {
        val individual = Individual.IndividualBuilder().setA(0).setS(0).build()
        assert(individual.getS() == 0)
        assert(individual.getH() == 31)
    }

    @Test
    @DisplayName("HPを担当するクラス")
    fun test003() {
        val hp = HP(181)
        hp.makeHPHalf()
        assert(hp.currentHP == 91)
        hp.decreaseHP(200)
        assert(hp.currentHP == 0)
    }

    @Test
    @DisplayName("フィールドクラス")
    fun test004() {
        val field = Field(FieldType.ELECTRIC_FIELD)
        field.forwardTurn()
        field.forwardTurn()
        field.forwardTurn()
        assert(!field.forwardTurn())
        assert(field.forwardTurn())
        assert(field.typeBoost(TypeSelect.ELECTRIC) == CalculationConst.ONE_POINT_THREE)
    }

    @Test
    @DisplayName("タイプクラス")
    fun test005() {
        val types = Type(listOf(TypeSelect.WATER, TypeSelect.GROUND))
        assert(4.0 == types.getTypeCompatibility(TypeSelect.GRASS))
    }
}