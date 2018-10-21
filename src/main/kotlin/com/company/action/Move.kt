package com.company.action

import com.company.GameAttributes
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.Insert
import com.company.event.Remove
import com.company.event.StatusUpdateEvent
import com.company.simmap.Direction
import com.company.simmap.SimMap

class Move(private val owner: Automaton, private val direction: Direction) : SimAction {

    override fun execute(ga: GameAttributes, simMap: SimMap): List<Event> {
        val ownerLocation = simMap.getLocation(owner) ?: return emptyList()
        val targetLocation = ownerLocation.getNeighbor(direction)
        if (owner.getStatus().energy >= ga.moveEnergy + ga.moveEnergyReserve && simMap.isEmpty(targetLocation)) {
            println("moved from $ownerLocation to $targetLocation")
            return listOf(
                    Remove(ownerLocation),
                    Insert(targetLocation, owner),
                    StatusUpdateEvent(owner.getStatus(), Status.StatusChange(0.0, -ga.moveEnergy))
            )
        }
        return emptyList()
    }

}
