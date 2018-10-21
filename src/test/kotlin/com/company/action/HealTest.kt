package com.company.action

import com.company.automaton.Status
import com.company.automaton.TestAutomaton
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HealTest {

    val simMap = SimMap(10, 10)
    val auto = TestAutomaton()

    @Test
    fun healConvertsEnergyToHealth() {
        auto.getStatus().health -= 10
        assertThat(Heal(auto).execute(simMap)).containsOnly(
                StatusUpdateEvent(
                        auto.getStatus(),
                        Status.StatusChange(Heal.healthGained, -Heal.energyRequired)
                )
        )
    }

    @Test
    fun healDoesNothingIfAutoFullHealth() {
        assertThat(Heal(auto).execute(simMap)).isEmpty()
    }

    @Test
    fun healDoesNothingIfAutoDoesNotHaveEnoughEnergy() {
        auto.getStatus().energy = Heal.energyRequired - 1.0
        assertThat(Heal(auto).execute(simMap)).isEmpty()
    }

}