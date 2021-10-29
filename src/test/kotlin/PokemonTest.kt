import com.sasakirione.pokemon.simulator.domain.value.status.Effort
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.Asserter
import kotlin.test.assertFails

class PokemonTest {
    @Test
    @DisplayName("努力値担当クラスのテスト")
    fun test001() {
        val effort1 = Effort(arrayOf(252, 0, 0, 252, 0, 4))
        assertFails { Effort(arrayOf(252, 252, 252, 252, 252, 252)) }
        assertFails { Effort(arrayOf(500, 0, 0, 0, 0, 10)) }
    }
}