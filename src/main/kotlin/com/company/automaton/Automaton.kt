package com.company.automaton

import com.company.action.SimAction

interface Automaton {

    fun tick(): SimAction

    fun getStatus(): Status

}