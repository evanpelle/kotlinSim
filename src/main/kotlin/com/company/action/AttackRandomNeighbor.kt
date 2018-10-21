package com.company.action

import com.company.automaton.Automaton
import com.company.event.Event
import com.company.simmap.SimMap

data class AttackRandomNeighbor(private val auto: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        val randomNeighborWithAuto = simMap.getRandomNeighborWithAuto(simMap.getLocation(auto) ?: return emptyList())
                ?: return emptyList()
        return Attack(
                auto,
                simMap.getAutomaton(randomNeighborWithAuto) ?: return emptyList()
        ).execute(simMap)
    }

}