package com.company.event.basicaction

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Action
import com.company.event.Insert
import com.company.event.Remove
import com.company.event.StatusUpdate
import com.company.event.complexaction.ComplexAction
import com.company.simmap.Direction
import com.company.simmap.SimMap

data class Move(private val owner: Automaton, private val direction: Direction) : ComplexAction {

    companion object {
        const val moveEnergy = 30.0
        const val moveEnergyReserve = 20.0
    }

    override fun execute(simMap: SimMap): List<Action> {
        val ownerLocation = simMap.getLocation(owner) ?: return emptyList()
        val targetLocation = ownerLocation.getNeighbor(direction)
        if (owner.getStatus().energy >= moveEnergy + moveEnergyReserve && simMap.isEmpty(targetLocation)) {
            return listOf(
                    Remove(ownerLocation),
                    Insert(targetLocation, owner),
                    StatusUpdate(owner.getStatus(), Status.StatusChange(0.0, -moveEnergy))
            )
        }
        return emptyList()
    }

}
