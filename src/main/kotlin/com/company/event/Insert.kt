package com.company.event

import com.company.automaton.Automaton
import com.company.simmap.Loc
import com.company.simmap.SimMap

class Insert(private val locToInsert: Loc, private val autoToInsert: Automaton) : BasicEvent {

    override fun execute(simMap: SimMap) {
        simMap.addAutomaton(locToInsert, autoToInsert)
    }

}