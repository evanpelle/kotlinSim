package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.SimMap

class AttackRandomNeighbor(private val auto: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        val randomNeighborWithAuto = simMap.getRandomNeighborWithAuto(simMap.getLocation(auto) ?: return) ?: return
        Attack(auto, simMap.getAutomaton(randomNeighborWithAuto) ?: return).performAction(simMap)
    }

}