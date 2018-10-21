package com.company.action

import com.company.simmap.SimMap
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent

class ReproduceAction(private val parent: Automaton, private val child: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        if (parent.getStatus().health > 50 && parent.getStatus().energy > 50) {
            val emptyNeighbor = simMap.getRandomEmptyNeighbor(simMap.getLocation(parent) ?: return emptyList())
                    ?: return emptyList()
            return listOf(StatusUpdateEvent(parent.getStatus(), Status.StatusChange(-50.0, -50.0)),
                    PlaceAuto(child, emptyNeighbor))
        }
        return emptyList()
    }

}