package com.company.event.complexaction

import com.company.automaton.AnimalAutomaton
import com.company.automaton.Automaton
import com.company.event.Action
import com.company.event.basicaction.Attack
import com.company.event.basicaction.Reproduce
import com.company.simmap.SimMap
import java.util.*

data class AnimalAction(private val auto: Automaton, private val random: Random) : ComplexAction {

    constructor(auto: Automaton) : this(auto, Random())

    override fun execute(simMap: SimMap): Action {
        val restOrHeal = RestOrHealAction(auto.status)
        if (restOrHeal.isValid()) {
            return restOrHeal
        }
        if (random.nextDouble() < .8) {
            val neighborsToAttack = simMap.getNeighbors(auto)
                    .filter { it.status.attributes.strength < auto.status.attributes.strength }
            if (neighborsToAttack.isNotEmpty()) {
                return Attack(auto, neighborsToAttack[0]))
            }
        }

        if (random.nextDouble() < .5) {
            return RandomMove(auto)
        }

        return Reproduce(auto) { AnimalAutomaton() }
    }

}