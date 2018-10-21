package com.company.action

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

class Metabolize(private val auto: Automaton) : SimAction {

    companion object {
        const val metabolizeAmount = 1.0
    }

    override fun execute(simMap: SimMap): List<Event> {
        return listOf(
                StatusUpdateEvent(
                        auto.getStatus(),
                        Status.StatusChange(0.0, -metabolizeAmount)
                )
        )
    }

}