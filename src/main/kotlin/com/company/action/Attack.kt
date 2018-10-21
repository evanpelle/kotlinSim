package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.SimMap
import kotlin.math.min

class Attack(private val attacker: Automaton, private val attacked: Automaton): SimAction {

    override fun performAction(simMap: SimMap) {
        if (attacker.getStatus().energy < 40) {
            return
        }
        val attackerLocation = simMap.getLocation(attacker) ?: return
        val attackedLocation = simMap.getLocation(attacked) ?: return
        if (attackerLocation.isNeighbor(attackedLocation)) {
            attacker.getStatus().health += min(attacker.getStatus().attributes.maxHealth, attacked.getStatus().health)
            attacker.getStatus().energy -= 30
            println("$attacker at location $attackedLocation attacked and killed $attacked at $attackedLocation")
            Death(attacked).performAction(simMap)
        }
    }

}