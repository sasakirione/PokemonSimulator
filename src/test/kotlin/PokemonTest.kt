import com.sasakirione.pokemon.simulator.domain.value.status.Effort
import com.sasakirione.pokemon.simulator.domain.value.status.Individual
import org.junit.jupiter.api.DisplayName
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
    @DisplayName("")
    fun test003() {

    }
}