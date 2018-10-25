package com.company.action

import com.company.automaton.AnimalAutomaton
import com.company.automaton.Automaton
import com.company.event.Event
import com.company.simmap.SimMap
import java.util.*

data class AnimalAction(private val auto: Automaton, private val random: Random) : SimAction {

    constructor(auto: Automaton) : this(auto, Random())

    override fun execute(simMap: SimMap): List<Event> {
        val restOrHeal = RestOrHealAction(auto.getStatus())
        if (restOrHeal.isValid()) {
            return listOf(restOrHeal)
        }
        if (random.nextDouble() < .8) {
            val neighborsToAttack = simMap.getNeighbors(auto)
                    .filter { it.getStatus().attributes.strength < auto.getStatus().attributes.strength }
            if (neighborsToAttack.isNotEmpty()) {
                return listOf(Attack(auto, neighborsToAttack[0]))
            }
        }

        if (random.nextDouble() < .5) {
            return listOf(RandomMove(auto))
        }

        return listOf(ReproduceAction(auto) { AnimalAutomaton() })
    }

}