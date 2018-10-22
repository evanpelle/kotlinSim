package com.company.automaton

import com.company.action.DoNothing
import com.company.action.SimAction

data class TestAutomaton(private val status: Status) : Automaton {

    override fun getStatus(): Status {
        return status
    }

    constructor() : this(Status.createDefault())

    override fun tick(): SimAction {
        return DoNothing()
    }

}