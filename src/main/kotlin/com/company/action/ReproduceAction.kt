package com.company.action

import com.company.simmap.SimMap
import com.company.automaton.Automaton

class ReproduceAction(private val parent: Automaton, private val child: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        if (parent.getStatus().health > 50 && parent.getStatus().energy > 50) {
            val emptyNeighbor = simMap.getRandomEmptyNeighbor(simMap.getLocation(parent) ?: return) ?: return
            parent.getStatus().energy -= 50
            parent.getStatus().health -= 50
            child.getStatus().energy = 50.0
            child.getStatus().health = 50.0
            PlaceAuto(child, emptyNeighbor).performAction(simMap)
        }
    }

}