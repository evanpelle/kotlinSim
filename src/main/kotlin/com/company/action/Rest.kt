package com.company.action

import com.company.action.SimAction
import com.company.automaton.Automaton
import com.company.simmap.SimMap

class Rest(private val auto: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        if (auto.getStatus().health > 6 && auto.getStatus().energy <= auto.getStatus().attributes.maxEnergy - 20) {
            auto.getStatus().health -= 5
            auto.getStatus().energy += 20
        }
    }

}