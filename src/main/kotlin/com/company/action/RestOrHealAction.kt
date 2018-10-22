package com.company.action

import com.company.automaton.Status
import com.company.event.Event
import com.company.simmap.SimMap

data class RestOrHealAction(private val status: Status,
                            private val healthThreshold: Double,
                            private val energyThreshold: Double) : SimAction {

    constructor(status: Status) : this(status, 20.0, 65.0)


    fun isValid(): Boolean {
        return shouldHeal() || shouldRest()
    }

    override fun execute(simMap: SimMap): List<Event> {
        if (shouldHeal()) {
            return listOf(Heal(status))
        }
        if (shouldRest()) {
            return listOf(Rest(status))
        }
        return emptyList()
    }

    private fun shouldHeal(): Boolean {
        if (status.health < healthThreshold) {
            return status.energy > energyThreshold
        }
        return false
    }

    private fun shouldRest(): Boolean {
        if (status.energy < energyThreshold) {
            return status.health > healthThreshold
        }
        return false
    }

}