package com.company.event.complexaction

import com.company.automaton.Status
import com.company.automaton.TestAutomaton
import com.company.event.StatusUpdate
import com.company.event.basicaction.Heal
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HealTest {

    val simMap = SimMap(10, 10)
    val auto = TestAutomaton()

    @Test
    fun healConvertsEnergyToHealth() {
        auto.getStatus().health -= 10
        assertThat(Heal(auto.getStatus()).execute(simMap)).containsOnly(
                StatusUpdate(
                        auto.getStatus(),
                        Status.StatusChange(Heal.healthGained, -Heal.energyRequired)
                )
        )
    }

    @Test
    fun healDoesNothingIfAutoFullHealth() {
        assertThat(Heal(auto.getStatus()).execute(simMap)).isEmpty()
    }

    @Test
    fun healDoesNothingIfAutoDoesNotHaveEnoughEnergy() {
        auto.getStatus().energy = Heal.energyRequired - 1.0
        assertThat(Heal(auto.getStatus()).execute(simMap)).isEmpty()
    }

}