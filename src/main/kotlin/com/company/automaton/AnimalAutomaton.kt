package com.company.automaton

import com.company.event.complexaction.AnimalAction
import com.company.event.complexaction.ComplexAction

data class AnimalAutomaton(private val status: Status): Automaton {

    constructor(): this(Status.fullStatus(Attributes(100.0, 100.0, 200.0)))

    override fun getStatus(): Status {
        return status
    }


    override fun tick(): ComplexAction {
        return AnimalAction(this)
    }

}