package com.company.event.complexaction

import com.company.automaton.Automaton
import com.company.event.Action
import com.company.event.basicaction.Move
import com.company.simmap.SimMap

data class RandomMove(private val owner: Automaton) : ComplexAction {

    override fun execute(simMap: SimMap): List<Action> {
        val location = simMap.getLocation(owner) ?: return emptyList()
        val targetLocation = simMap.getRandomEmptyNeighbor(location) ?: return emptyList()
        val direction = location.getDirection(targetLocation) ?: return emptyList()
        return listOf(Move(owner, direction))
    }

}