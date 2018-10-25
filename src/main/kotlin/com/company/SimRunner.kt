package com.company

import com.company.event.basicaction.Death
import com.company.event.basicaction.Metabolize
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
