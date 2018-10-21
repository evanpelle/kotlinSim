package com.company.action

import com.company.GameAttributes
import com.company.event.Event
import com.company.simmap.SimMap

interface SimAction: Event {

    fun execute(ga: GameAttributes, simMap: SimMap): List<Event>

}
