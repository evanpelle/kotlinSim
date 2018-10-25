package com.company.event.basicaction

import com.company.simmap.SimMap
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Action
import com.company.event.StatusUpdate
import com.company.event.complexaction.ComplexAction
import com.company.event.complexaction.PlaceAuto

data class Reproduce(private val parent: Automaton, private val childBuilder: () -> Automaton) : ComplexAction {

    companion object {
        const val healthCost = 50.0
        const val energyCost = 50.0

        const val childHealth = 25.0
        const val childEnergy = 25.0
    }

    override fun execute(simMap: SimMap): List<Action> {
        if (parent.getStatus().health > healthCost
                && parent.getStatus().energy > energyCost) {
            val emptyNeighbor = simMap.getRandomEmptyNeighbor(simMap.getLocation(parent) ?: return emptyList())
                    ?: return emptyList()
            val autoToBirth = childBuilder.invoke()
            autoToBirth.getStatus().health = childHealth
            autoToBirth.getStatus().energy = childEnergy
            return listOf(
                    StatusUpdate(
                            parent.getStatus(),
                            Status.StatusChange(-healthCost, -energyCost)
                    ),
                    PlaceAuto(autoToBirth, emptyNeighbor)
            )
        }
        return emptyList()
    }

}