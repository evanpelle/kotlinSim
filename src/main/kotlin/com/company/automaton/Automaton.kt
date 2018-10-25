package com.company.automaton

import com.company.event.Action
import com.company.event.complexaction.ComplexAction
import com.company.simmap.SimMap

data class Automaton(val attributes: Attributes, val status: Status, val action: ComplexAction) {

    constructor(attributes: Attributes, action: ComplexAction) : this(attributes, attributes.createMaxStatus(), action)

    fun act(simMap: SimMap): Action {
        return action.execute(this, simMap)
    }

}