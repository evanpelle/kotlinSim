package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.SimMap

class Death(private val auto: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        if (auto.getStatus().health <= 0 || auto.getStatus().energy <= 0) {
            println("auto $auto at location ${simMap.getLocation(auto)} died")
            simMap.removeAutomaton(auto)
        }
    }

}