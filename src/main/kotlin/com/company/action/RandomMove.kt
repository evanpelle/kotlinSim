package com.company.action

import com.company.automaton.Automaton
import com.company.event.Event
import com.company.simmap.SimMap

class RandomMove(private val owner: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        val location = simMap.getLocation(owner) ?: return emptyList()
        val targetLocation = simMap.getRandomEmptyNeighbor(location) ?: return emptyList()
        val direction = location.getDirection(targetLocation) ?: return emptyList()
        return listOf(Move(owner, direction))
    }

}