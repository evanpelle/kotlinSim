package com.company.action

import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

data class Rest(private val status: Status) : SimAction {

    companion object {
        const val healthCost = .1
        const val energyGained = 2.0
    }

    override fun execute(simMap: SimMap): List<Event> {
        if (status.health > healthCost
                && status.energy <= status.attributes.maxEnergy - energyGained) {
            return listOf(StatusUpdateEvent(status, Status.StatusChange(-healthCost, energyGained)))
        }
        return emptyList()
    }

}