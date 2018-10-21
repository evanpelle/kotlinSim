package com.company.action

import com.company.GameAttributes
import com.company.simmap.SimMap
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent

class ReproduceAction(private val parent: Automaton, private val child: Automaton) : SimAction {

    override fun execute(ga: GameAttributes, simMap: SimMap): List<Event> {
        if (parent.getStatus().health > ga.reproduceHealthCost
                && parent.getStatus().energy > ga.reproduceEnergyCost) {
            val emptyNeighbor = simMap.getRandomEmptyNeighbor(simMap.getLocation(parent) ?: return emptyList())
                    ?: return emptyList()
            return listOf(
                    StatusUpdateEvent(
                            parent.getStatus(),
                            Status.StatusChange(-ga.reproduceHealthCost, -ga.reproduceEnergyCost)
                    ),
                    PlaceAuto(child, emptyNeighbor)
            )
        }
        return emptyList()
    }

}