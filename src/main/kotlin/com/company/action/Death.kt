package com.company.action

import com.company.GameAttributes
import com.company.automaton.Automaton
import com.company.event.Event
import com.company.event.Remove
import com.company.simmap.SimMap

class Death(private val auto: Automaton) : SimAction {

    override fun execute(ga: GameAttributes, simMap: SimMap): List<Event> {
        if (auto.getStatus().health <= 0 || auto.getStatus().energy <= 0) {
            println("auto $auto at location ${simMap.getLocation(auto)} died")
            val loc = simMap.getLocation(auto)!!
            return listOf(Remove(loc))
        }
        return emptyList()
    }

}