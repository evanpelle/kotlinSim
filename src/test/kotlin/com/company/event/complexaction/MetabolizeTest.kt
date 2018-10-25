package com.company.event.complexaction

import com.company.automaton.Status
import com.company.automaton.TestAutomaton
import com.company.event.StatusUpdate
import com.company.event.basicaction.Metabolize
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MetabolizeTest {

    @Test
    fun metabolizeReducesEnergy() {
        val auto = TestAutomaton()
        assertThat(
                Metabolize(auto).execute(SimMap(10, 10))
        ).containsOnly(
                StatusUpdate(
                        auto.getStatus(),
                        Status.StatusChange(0.0, -Metabolize.metabolizeAmount)
                )
        )
    }

}