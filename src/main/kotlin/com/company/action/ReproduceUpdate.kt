package com.company.action

import com.company.simmap.Direction
import com.company.simmap.Location
import com.company.simmap.SimMap
import com.company.automaton.Automaton

class ReproduceUpdate(private val _auto: Automaton,
                      private val _loc: Location,
                      private val _simMap: SimMap) : SimUpdate {
    override fun performAction(simMap: SimMap) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}