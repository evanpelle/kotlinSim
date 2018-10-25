package com.company

import com.company.event.complexaction.ComplexAction
import com.company.event.basicaction.BasicAction
import com.company.event.Action
import com.company.simmap.SimMap

class ActionExecutor {

    fun executeAction(simMap: SimMap, action: Action) {
        executeActions(simMap, listOf(action))
    }

    fun executeActions(simMap: SimMap, actions: List<Action>) {
        for (action in actions) {
            when (action) {
                is BasicAction -> action.execute(simMap)
                is ComplexAction -> executeActions(simMap, action.execute(simMap))
            }
        }
    }
}