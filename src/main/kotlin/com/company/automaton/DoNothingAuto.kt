package com.company.automaton

import com.company.event.basicaction.DoNothing
import com.company.event.complexaction.ComplexAction

class DoNothingAuto: AutomatonImpl(Status.createDefault()) {

    override fun tick(): ComplexAction {
        return DoNothing()
    }

}