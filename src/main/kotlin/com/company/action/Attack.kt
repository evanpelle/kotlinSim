package com.company.action

import com.company.GameAttributes
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.Remove
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap

data class Attack(private val attacker: Automaton, private val attacked: Automaton): SimAction {

    companion object {
        const val attackEnergy = 40.0
    }

    override fun execute(ga: GameAttributes, simMap: SimMap): List<Event> {
        if (attacker.getStatus().energy < ga.attackEnergy) {
            return emptyList()
        }
        val attackerLocation = simMap.getLocation(attacker) ?: return emptyList()
        val attackedLocation = simMap.getLocation(attacked) ?: return emptyList()
        if (attackerLocation.isNeighbor(attackedLocation)) {
            val attackerStatusUpdate = StatusUpdateEvent(attacker.getStatus(), Status.StatusChange(0.0, -attackEnergy))
            println("$attacker at location $attackedLocation attacked and killed $attacked at $attackedLocation")
            return listOf(attackerStatusUpdate) + Remove(attackedLocation)
        }
        return emptyList()
    }

}