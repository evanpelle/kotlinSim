package com.company.event

import com.company.automaton.Status
import com.company.simmap.SimMap

class StatusUpdateEvent(private val statusToUpdate: Status,
                        private val statusChange: Status.StatusChange) : Event {

    override fun execute(simMap: SimMap) {
        statusToUpdate.update(statusChange)
    }

}