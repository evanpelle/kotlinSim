package com.company.action

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

class Attack(private val attacker: Automaton, private val attacked: Automaton): SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        if (attacker.getStatus().energy < 40) {
            return emptyList()
        }
        val attackerLocation = simMap.getLocation(attacker) ?: return emptyList()
        val attackedLocation = simMap.getLocation(attacked) ?: return emptyList()
        if (attackerLocation.isNeighbor(attackedLocation)) {
            val attackerStatusUpdate = StatusUpdateEvent(attacker.getStatus(), Status.StatusChange(0.0, -30.0))

            println("$attacker at location $attackedLocation attacked and killed $attacked at $attackedLocation")
            return listOf(attackerStatusUpdate) + Death(attacked)
        }
        return emptyList()
    }

}