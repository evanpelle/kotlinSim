package com.company.action

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

data class Heal(private val auto: Automaton) : SimAction {

    companion object {
        const val healthGained = 5.0
        const val energyRequired = 25.0
    }

    override fun execute(simMap: SimMap): List<Event> {
        if (auto.getStatus().energy > energyRequired
                && auto.getStatus().health < auto.getStatus().attributes.maxHealth - healthGained) {
            return listOf(
                    StatusUpdateEvent(
                            auto.getStatus(),
                            Status.StatusChange(healthGained, -energyRequired)
                    )
            )
        }
        return emptyList()
    }

}