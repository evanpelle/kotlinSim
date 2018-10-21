package com.company.action

import com.company.GameAttributes
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

class Metabolize(private val auto: Automaton) : SimAction {

    override fun execute(ga: GameAttributes, simMap: SimMap): List<Event> {
        return listOf(
                StatusUpdateEvent(
                        auto.getStatus(),
                        Status.StatusChange(0.0, -ga.metabolizeAmount)
                )
        )
    }

}