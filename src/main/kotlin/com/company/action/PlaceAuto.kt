package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.Location
import com.company.simmap.SimMap

class PlaceAuto(private val auto: Automaton, private val loc: Location) : SimAction {

    override fun performAction(simMap: SimMap) {
        if (simMap.canMoveOn(loc)) {
            simMap.addAutomaton(loc, auto)
            println("auto $auto at $loc born")
        }
    }

}