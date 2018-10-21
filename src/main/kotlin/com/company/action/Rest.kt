package com.company.action

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

class Rest(private val auto: Automaton) : SimAction {

    companion object {
        const val healthCost = 5.0
        const val energyGained = 25.0
    }

    override fun execute(simMap: SimMap): List<Event> {
        if (auto.getStatus().health > healthCost
                && auto.getStatus().energy <= auto.getStatus().attributes.maxEnergy - energyGained) {
            return listOf(StatusUpdateEvent(auto.getStatus(), Status.StatusChange(-healthCost, energyGained)))
        }
        return emptyList()
    }

}