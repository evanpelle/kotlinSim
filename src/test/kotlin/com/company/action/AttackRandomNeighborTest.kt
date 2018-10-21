package com.company.action

import com.company.ActionExecutor
import com.company.GameAttributes
import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttackRandomNeighborTest {

    private val gameAttributes = GameAttributes.default()
    private val simMap = SimMap(10, 10)

    private val attacker = TestAutomaton()
    private val attacked = TestAutomaton()

    @Test
    fun attackingRandomNeighborDoesNothingIfThereAreNoNeighbors() {
        simMap.addAutomaton(Loc(1, 1), attacker)
        assertThat(AttackRandomNeighbor(attacker).execute(gameAttributes, simMap)).isEmpty()
    }

    @Test
    fun attackingRandomNeighborAttacksOnlyNeighbor() {
        simMap.addAutomaton(Loc(1, 1), attacker)
        simMap.addAutomaton(Loc(2, 1), attacked)
        ActionExecutor().executeAction(gameAttributes, simMap, AttackRandomNeighbor(attacker))
        assertThat(simMap.isEmpty(Loc(2, 1))).isTrue()
    }

}