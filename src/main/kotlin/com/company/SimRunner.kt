package com.company

import com.company.action.Death
import com.company.action.Metabolize
import com.company.simmap.SimMap

class SimRunner(private val executor: ActionExecutor) {

    fun tick(simMap: SimMap) {
        for (auto in simMap.getAutomatons()) {
            val action = auto.tick()
            executor.executeActions(simMap, listOf(action))
            executor.executeActions(simMap, listOf(Metabolize(auto)))
            executor.executeActions(simMap, listOf(Death(auto)))
        }
    }

}
