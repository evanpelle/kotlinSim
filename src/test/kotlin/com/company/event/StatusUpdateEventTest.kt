package com.company.event

import com.company.automaton.Attributes
import com.company.automaton.Status
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatusUpdateEventTest {

    val simMap = SimMap(10, 10)

    val status = Status(
            Attributes.createDefault(),
            50.0,
            50.0
    )

    @Test
    fun addingEnergyAndHealth() {
        StatusUpdateEvent(status, Status.StatusChange(10.0, 10.0)).execute(simMap)
        assertThat(status.health).isEqualTo(60.0)
        assertThat(status.energy).isEqualTo(60.0)
    }

    @Test
    fun subtractingEnergyAndHealth() {
        StatusUpdateEvent(status, Status.StatusChange(-10.0, -10.0)).execute(simMap)
        assertThat(status.health).isEqualTo(40.0)
        assertThat(status.energy).isEqualTo(40.0)
    }

}