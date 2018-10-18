package com.company

import com.company.action.Death
import com.company.action.Metabolize
import com.company.simmap.SimMap

class SimRunner {

    fun tick(simMap: SimMap) {
        for (auto in simMap.getAutomatons()) {
            val action = auto.tick()
            action.performAction(simMap)
            Metabolize(auto).performAction(simMap)
            Death(auto).performAction(simMap)
        }
    }

}
