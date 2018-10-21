package com.company.event

import com.company.simmap.Loc
import com.company.simmap.SimMap

class Remove(val locToRemove: Loc): BasicEvent {

    override fun execute(simMap: SimMap) {
        simMap.removeAutomaton(locToRemove)
    }

}