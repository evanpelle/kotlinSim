package com.company.automaton

import com.company.action.DoNothing
import com.company.action.SimUpdate

class PlantAutomaton : AutomatonImpl(Status.createDefault()) {

    override fun tick(): SimUpdate {
        return DoNothing()
    }

}
