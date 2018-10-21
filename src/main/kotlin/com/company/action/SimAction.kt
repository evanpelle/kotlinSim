package com.company.action

import com.company.event.Event
import com.company.simmap.SimMap

interface SimAction: Event {

    fun execute(simMap: SimMap): List<Event>

}
