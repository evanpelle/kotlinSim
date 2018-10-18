package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.Direction
import com.company.simmap.SimMap

class Move(private val owner: Automaton, private val direction: Direction) : SimAction {

    override fun performAction(simMap: SimMap) {
        val ownerLocation = simMap.getLocation(owner)
        if (ownerLocation != null) {
            val targetLocation = ownerLocation.getNeighbor(direction)
            if (owner.getStatus().energy >= 5 && simMap.isEmpty(targetLocation)) {
                simMap.removeAutomaton(ownerLocation)
                simMap.addAutomaton(targetLocation, owner)
                owner.getStatus().energy -= 5
                println("moved from $ownerLocation to $targetLocation")
            }
        }
    }

}
