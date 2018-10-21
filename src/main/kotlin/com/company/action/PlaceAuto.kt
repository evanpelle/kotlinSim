package com.company.action

import com.company.automaton.Automaton
import com.company.event.Event
import com.company.event.Insert
import com.company.simmap.Loc
import com.company.simmap.SimMap

class PlaceAuto(private val auto: Automaton, private val loc: Loc) : SimAction {

    override fun execute(simMap: SimMap): List<Event> {
        if (simMap.canMoveOn(loc)) {
            println("auto $auto at $loc born")
            return listOf(Insert(loc, auto))
        }
        return emptyList()
    }

}