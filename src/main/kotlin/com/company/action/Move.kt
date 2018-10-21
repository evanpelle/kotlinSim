package com.company.action

import com.company.action.SimAction
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.Insert
import com.company.event.Remove
import com.company.event.StatusUpdateEvent
import com.company.simmap.Direction
import com.company.simmap.SimMap

class Move(private val owner: Automaton, private val direction: Direction) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        val ownerLocation = simMap.getLocation(owner) ?: return emptyList()
        val targetLocation = ownerLocation.getNeighbor(direction)
        if (owner.getStatus().energy >= 5 && simMap.isEmpty(targetLocation)) {
            println("moved from $ownerLocation to $targetLocation")
            return listOf(
                    Remove(ownerLocation),
                    Insert(targetLocation, owner),
                    StatusUpdateEvent(owner.getStatus(), Status.StatusChange(0.0, -.5))
            )
        }
        return emptyList()
    }

}
