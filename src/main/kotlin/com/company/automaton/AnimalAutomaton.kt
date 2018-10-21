package com.company.automaton

import com.company.action.*
import com.company.action.DoNothing
import com.company.action.Rest

class AnimalAutomaton: AutomatonImpl(Status.createDefault()) {

    override fun tick(): SimAction {
        return AnimalAction(this)
    }

}