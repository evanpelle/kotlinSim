package com.company.automaton

import com.company.event.basicaction.DoNothing
import com.company.event.complexaction.ComplexAction

data class TestAutomaton(private val status: Status) : Automaton {

    override fun getStatus(): Status {
        return status
    }

    constructor() : this(Status.createDefault())

    override fun tick(): ComplexAction {
        return DoNothing()
    }

}