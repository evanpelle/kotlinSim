package com.company.action

import com.company.automaton.Automaton
import com.company.event.Event
import com.company.simmap.SimMap

data class AnimalAction(private val auto: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        val randomEmptyNeighbor = simMap.getRandomNeighborWithAuto(simMap.getLocation(auto) ?: return emptyList())
        if (randomEmptyNeighbor != null) {
            return listOf(AttackRandomNeighbor(auto))
        }
        return listOf(RandomMove(auto))
    }

}