package com.company.event

import com.company.simmap.Loc
import com.company.simmap.SimMap

class Remove(val locToRemove: Loc): Event {

    override fun execute(simMap: SimMap) {
        simMap.removeAutomaton(locToRemove)
    }

}