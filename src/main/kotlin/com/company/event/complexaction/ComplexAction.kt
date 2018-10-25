package com.company.event.complexaction

import com.company.automaton.Automaton
import com.company.event.Action
import com.company.simmap.SimMap

interface ComplexAction: Action {

    fun execute(auto: Automaton, simMap: SimMap): Action

}
