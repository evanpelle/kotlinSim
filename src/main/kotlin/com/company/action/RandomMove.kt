package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.SimMap

class RandomMove(private val owner: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        val location = simMap.getLocation(owner) ?: return
        val targetLocation = simMap.getRandomEmptyNeighbor(location) ?: return
        val direction = location.getDirection(targetLocation) ?: return
        Move(owner, direction).performAction(simMap)
    }

}