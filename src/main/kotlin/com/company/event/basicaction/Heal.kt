package com.company.event.basicaction

import com.company.automaton.Status
import com.company.event.Action
import com.company.event.StatusUpdate
import com.company.event.complexaction.ComplexAction
import com.company.simmap.SimMap

data class Heal(private val status: Status) : ComplexAction {

    companion object {
        const val healthGained = 5.0
        const val energyRequired = 25.0
    }

    override fun execute(simMap: SimMap): List<Action> {
        if (status.energy > energyRequired
                && status.health < status.attributes.maxHealth - healthGained) {
            return listOf(
                    StatusUpdate(
                            status,
                            Status.StatusChange(healthGained, -energyRequired)
                    )
            )
        }
        return emptyList()
    }

}