package com.company.automaton

import com.company.action.DoNothing
import com.company.action.RandomMove
import com.company.action.SimUpdate

class MoveAutomaton: AutomatonImpl(Status.createDefault()) {

    override fun tick(): SimUpdate {
        if (getStatus().health > 30) {
            return RandomMove(this)
        }
        return DoNothing()
    }

}