package com.company.action

import com.company.automaton.Automaton
import com.company.simmap.SimMap

class Heal(private val auto: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        if (auto.getStatus().energy > 25 && auto.getStatus().health < auto.getStatus().maxHealth - 5) {
            auto.getStatus().health += 5
            auto.getStatus().energy -= 20
        }
    }

}