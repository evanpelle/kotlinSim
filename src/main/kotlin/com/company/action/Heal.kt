package com.company.action

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

data class Heal(private val status: Status) : SimAction {

    companion object {
        const val healthGained = 5.0
        const val energyRequired = 25.0
    }

    override fun execute(simMap: SimMap): List<Event> {
        if (status.energy > energyRequired
                && status.health < status.attributes.maxHealth - healthGained) {
            return listOf(
                    StatusUpdateEvent(
                            status,
                            Status.StatusChange(healthGained, -energyRequired)
                    )
            )
        }
        return emptyList()
    }

}