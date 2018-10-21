package com.company

import com.company.action.Death
import com.company.action.Metabolize
import com.company.simmap.SimMap

class SimRunner(private val executor: ActionExecutor) {

    fun tick(gameAttributes: GameAttributes, simMap: SimMap) {
        for (auto in simMap.getAutomatons()) {
            val action = auto.tick()
            executor.executeActions(gameAttributes, simMap, listOf(action))
            executor.executeActions(gameAttributes, simMap, listOf(Metabolize(auto)))
            executor.executeActions(gameAttributes, simMap, listOf(Death(auto)))
        }
    }

}
