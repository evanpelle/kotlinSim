package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.SimMap

class RandomMove(private val owner: Automaton) : SimUpdate {

    override fun performAction(simMap: SimMap) {
        val location = simMap.getLocation(owner) ?: return
        val possibleCells = location.getNeighbors().filter { simMap.canMoveOn(it) }
        if (possibleCells.isNotEmpty()) {
            val targetLocation = possibleCells[(Math.random() * possibleCells.size).toInt()]
            val direction = location.getDirection(targetLocation) ?: return
            Move(owner, direction).performAction(simMap)
        }
    }

}