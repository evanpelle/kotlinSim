package com.company.action

import com.company.simmap.SimMap
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent

class ReproduceAction(private val parent: Automaton, private val childBuilder: () -> Automaton) : SimAction {

    companion object {
        const val healthCost = 50.0
        const val energyCost = 50.0

        const val childHealth = 25.0
        const val childEnergy = 25.0
    }

    override fun execute(simMap: SimMap): List<Event> {
        if (parent.getStatus().health > healthCost
                && parent.getStatus().energy > energyCost) {
            val emptyNeighbor = simMap.getRandomEmptyNeighbor(simMap.getLocation(parent) ?: return emptyList())
                    ?: return emptyList()
            val auto = childBuilder.invoke()
            auto.getStatus().health = childHealth
            auto.getStatus().energy = childEnergy
            return listOf(
                    StatusUpdateEvent(
                            parent.getStatus(),
                            Status.StatusChange(-healthCost, -energyCost)
                    ),
                    PlaceAuto(auto, emptyNeighbor)
            )
        }
        return emptyList()
    }

}