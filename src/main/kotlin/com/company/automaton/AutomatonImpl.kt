package com.company.automaton

abstract class AutomatonImpl(private val status: Status) : Automaton {

    override fun getStatus(): Status {
        return status
    }

}
