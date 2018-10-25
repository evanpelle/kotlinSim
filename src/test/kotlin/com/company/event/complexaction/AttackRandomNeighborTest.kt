package com.company.event.complexaction

import com.company.ActionExecutor
import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttackRandomNeighborTest {

    private val simMap = SimMap(10, 10)

    private val attacker = TestAutomaton()
    private val attacked = TestAutomaton()

    @Test
    fun attackingRandomNeighborDoesNothingIfThereAreNoNeighbors() {
        simMap.addAutomaton(Loc(1, 1), attacker)
        assertThat(AttackRandomNeighbor(attacker).execute(simMap)).isEmpty()
    }

    @Test
    fun attackingRandomNeighborAttacksOnlyNeighbor() {
        simMap.addAutomaton(Loc(1, 1), attacker)
        simMap.addAutomaton(Loc(2, 1), attacked)
        ActionExecutor().executeAction(simMap, AttackRandomNeighbor(attacker))
        assertThat(simMap.isEmpty(Loc(2, 1))).isTrue()
    }

}