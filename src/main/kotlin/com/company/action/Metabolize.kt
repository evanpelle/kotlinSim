package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.SimMap

class Metabolize(private val auto: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        auto.getStatus().energy -= 1
    }

}