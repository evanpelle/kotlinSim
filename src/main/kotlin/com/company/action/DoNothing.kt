package com.company.action

import com.company.action.SimAction
import com.company.event.Event
import com.company.simmap.SimMap

class DoNothing : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        return emptyList()
    }

}