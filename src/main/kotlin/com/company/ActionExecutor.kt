package com.company

import com.company.action.SimAction
import com.company.event.BasicEvent
import com.company.event.Event
import com.company.simmap.SimMap

class ActionExecutor {

    fun executeAction(gameAttributes: GameAttributes, simMap: SimMap, action: Event) {
        executeActions(gameAttributes, simMap, listOf(action))
    }

    fun executeActions(gameAttributes: GameAttributes, simMap: SimMap, actions: List<Event>) {
        for (action in actions) {
            when (action) {
                is BasicEvent -> action.execute(simMap)
                is SimAction -> executeActions(gameAttributes, simMap, action.execute(gameAttributes, simMap))
            }
        }
    }
}