package com.company.action

import com.company.GameAttributes
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

class Rest(private val auto: Automaton) : SimAction {

    override fun execute(ga: GameAttributes, simMap: SimMap): List<Event> {
        if (auto.getStatus().health > ga.restHealthRequired
                && auto.getStatus().energy <= auto.getStatus().attributes.maxEnergy - ga.restEnergyGained) {
            return listOf(StatusUpdateEvent(auto.getStatus(), Status.StatusChange(-ga.restHealthRequired, ga.restEnergyGained)))
        }
        return emptyList()
    }

}