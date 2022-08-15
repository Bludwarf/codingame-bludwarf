

import TestUtils.Companion.action
import TestUtils.Companion.gameState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class BestActionResolverTest {

    @ParameterizedTest
    @CsvSource(
        "ligue2/game-2362403142607370200-state-1.txt, USE 5 0, USE DISHWASHER",
        "ligue2/game-2362403142607370200-state-7.txt, USE 5 3, USE ICE_CREAM_CRATE",
    )
    fun resolveBestAction(gameStatePath: String, expectedActionString: String) {
        val gameState = gameState(gameStatePath)
        val bestActionResolver = BestActionResolver(PossibleActionResolverV2(gameState))

        val action = bestActionResolver.resolveBestActionFrom(gameState)

        val expectedAction = action(expectedActionString)
        assertThat(action).isEqualTo(expectedAction)
    }

}
