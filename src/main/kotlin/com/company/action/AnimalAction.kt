package com.company.action

import com.company.automaton.AnimalAutomaton
import com.company.automaton.Automaton
import com.company.event.Event
import com.company.simmap.SimMap

data class AnimalAction(private val auto: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        val restOrHeal = RestOrHealAction(auto.getStatus())
        if (restOrHeal.isValid()) {
            return listOf(restOrHeal)
        }

        val neighborsToAttack = simMap.getNeighbors(auto)
                .filter { it.getStatus().attributes.strength < auto.getStatus().attributes.strength }
        if (neighborsToAttack.isNotEmpty()) {
            return listOf(Attack(auto, neighborsToAttack[0]))
        }

        if (auto.getStatus().health > 80 && auto.getStatus().energy > 55) {
            return listOf(ReproduceAction(auto) {AnimalAutomaton()})
        }
        return listOf(RandomMove(auto))
    }

}