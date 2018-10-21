package com.company.action

import com.company.action.SimAction
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

class Heal(private val auto: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        if (auto.getStatus().energy > 25 && auto.getStatus().health < auto.getStatus().attributes.maxHealth - 5) {
            return listOf(StatusUpdateEvent(auto.getStatus(), Status.StatusChange(5.0, -20.0)))
        }
        return emptyList()
    }

}