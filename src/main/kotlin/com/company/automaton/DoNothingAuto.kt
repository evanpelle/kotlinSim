package com.company.automaton

import com.company.action.DoNothing
import com.company.action.SimAction

class DoNothingAuto: AutomatonImpl(Status.createDefault()) {

    override fun tick(): SimAction {
        return DoNothing()
    }

}