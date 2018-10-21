package com.company.action

import com.company.action.SimAction
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

class Rest(private val auto: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        if (auto.getStatus().health > 6 && auto.getStatus().energy <= auto.getStatus().attributes.maxEnergy - 20) {
            return listOf(StatusUpdateEvent(auto.getStatus(), Status.StatusChange(-5.0, -20.0)))
        }
        return emptyList()
    }

}