package com.company

import com.company.action.SimAction
import com.company.event.BasicEvent
import com.company.event.Event
import com.company.simmap.SimMap

class ActionExecutor {

    fun executeActions(simMap: SimMap, actions: List<Event>) {
        reduceToBasicEvents(simMap, actions).forEach { it.execute(simMap) }
    }

    private fun reduceToBasicEvents(simMap: SimMap, actions: List<Event>): List<BasicEvent> {
        val basicEvents: MutableList<BasicEvent> = mutableListOf()
        for (action in actions) {

            when (action) {
                is BasicEvent -> basicEvents.add(action)
                is SimAction -> basicEvents.addAll(reduceToBasicEvents(simMap, action.execute(simMap)))
            }
        }
        return basicEvents
    }
}