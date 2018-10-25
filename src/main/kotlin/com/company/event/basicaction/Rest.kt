package com.company.event.basicaction

import com.company.automaton.Status
import com.company.event.Action
import com.company.event.StatusUpdate
import com.company.event.complexaction.ComplexAction
import com.company.simmap.SimMap

data class Rest(private val status: Status) : ComplexAction {

    companion object {
        const val healthCost = .05
        const val energyGained = 3.0
    }

    override fun execute(simMap: SimMap): List<Action> {
        if (status.health > healthCost
                && status.energy <= status.attributes.maxEnergy - energyGained) {
            return listOf(StatusUpdate(status, Status.StatusChange(-healthCost, energyGained)))
        }
        return emptyList()
    }

}