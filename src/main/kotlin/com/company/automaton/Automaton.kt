package com.company.automaton

import com.company.action.SimUpdate

interface Automaton {

    fun tick(): SimUpdate

    fun getStatus(): Status

}