package com.company.event.complexaction

import com.company.automaton.Automaton
import com.company.event.Action
import com.company.event.basicaction.Attack
import com.company.simmap.SimMap

data class AttackRandomNeighbor(private val auto: Automaton) : ComplexAction {

    override fun execute(simMap: SimMap): List<Action> {
        val randomNeighborWithAuto = simMap.getRandomNeighborWithAuto(simMap.getLocation(auto) ?: return emptyList())
                ?: return emptyList()
        return Attack(
                auto,
                simMap.getAutomaton(randomNeighborWithAuto) ?: return emptyList()
        ).execute(simMap)
    }

}