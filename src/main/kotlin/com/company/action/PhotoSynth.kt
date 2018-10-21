package com.company.action

import com.company.action.SimAction
import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Event
import com.company.event.StatusUpdateEvent
import com.company.simmap.SimMap
import kotlin.math.min

class PhotoSynth(private val auto: Automaton) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        return listOf(StatusUpdateEvent(auto.getStatus(), Status.StatusChange(0.0, 5.0)))
    }

}
