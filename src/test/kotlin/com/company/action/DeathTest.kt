package com.company.action

import com.company.GameAttributes
import com.company.automaton.TestAutomaton
import com.company.event.Remove
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DeathTest {

    val gameAttributes = GameAttributes.default()
    val simMap = SimMap(10, 10)
    val auto = TestAutomaton()

    private val autoLoc = Loc(1, 1)

    @BeforeEach
    fun before() {
        simMap.addAutomaton(autoLoc, auto)
    }

    @Test
    fun deathDoesNothingIfEnergyAndHealthAboveZero() {
        assertThat(Death(auto).execute(gameAttributes, simMap)).isEmpty()
    }

    @Test
    fun deathKillsAutoIfHealthZero() {
        auto.getStatus().health = 0.0
        assertThat(Death(auto).execute(gameAttributes, simMap)).containsOnly(Remove(autoLoc))
    }

    @Test
    fun deathKillsAutoIfEnergyZero() {
        auto.getStatus().energy = 0.0
        assertThat(Death(auto).execute(gameAttributes, simMap)).containsOnly(Remove(autoLoc))
    }



}