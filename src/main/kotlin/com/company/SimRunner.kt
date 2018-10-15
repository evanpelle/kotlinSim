package com.company

import com.company.simmap.Location
import com.company.simmap.SimMap

class SimRunner {

    fun tick(simMap: SimMap) {
        for (auto in simMap.getAutomatons()) {
            val action = auto.tick()
            action.performAction(simMap)
        }
    }
}
