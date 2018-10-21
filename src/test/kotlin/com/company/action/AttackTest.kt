package com.company.action

import com.company.ActionExecutor
import com.company.GameAttributes
import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttackTest {

    private val gameAttributes = GameAttributes.default()
    private val simMap = SimMap(10, 10)
    private val actionExecutor = ActionExecutor()

    @Test
    fun attackingNeighborKillsIt() {
        val attacker = TestAutomaton()
        simMap.addAutomaton(Loc(1,1), attacker)
        val attacked = TestAutomaton()
        simMap.addAutomaton(Loc(2, 1), attacked)

        actionExecutor.executeAction(gameAttributes, simMap, Attack(attacker, attacked))

        assertThat(simMap.isEmpty(Loc(2, 1))).isTrue()
    }

    @Test
    fun attackingNeighborDoesNothingWhenAttackerEnergyBelowThreshold() {
        val attacker = TestAutomaton()
        simMap.addAutomaton(Loc(1,1), attacker)
        attacker.getStatus().energy = 10.0
        val attacked = TestAutomaton()
        simMap.addAutomaton(Loc(2, 1), attacked)

        actionExecutor.executeAction(gameAttributes, simMap, Attack(attacker, attacked))

        assertThat(simMap.isEmpty(Loc(2, 1))).isFalse()
    }

    @Test
    fun attackingNeighborDoesNothingWhenAttackerIsNotNeighborsWithAttacked() {
        val attacker = TestAutomaton()
        simMap.addAutomaton(Loc(1,1), attacker)
        val attacked = TestAutomaton()
        simMap.addAutomaton(Loc(2, 2), attacked)

        actionExecutor.executeAction(gameAttributes, simMap, Attack(attacker, attacked))

        assertThat(simMap.isEmpty(Loc(2, 2))).isFalse()
    }

}