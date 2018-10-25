package com.company.event.basicaction

import com.company.automaton.Automaton
import com.company.event.Action
import com.company.event.Remove
import com.company.event.complexaction.ComplexAction
import com.company.simmap.SimMap

class Death(private val auto: Automaton) : ComplexAction {

    override fun execute(simMap: SimMap): List<Action> {
        if (auto.getStatus().health <= 0 || auto.getStatus().energy <= 0) {
//            println("auto $auto at location ${simMap.getLocation(auto)} died")
            val loc = simMap.getLocation(auto)!!
            return listOf(Remove(loc))
        }
        return emptyList()
    }

}