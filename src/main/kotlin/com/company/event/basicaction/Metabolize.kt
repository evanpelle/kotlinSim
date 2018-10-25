package com.company.event.basicaction

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Action
import com.company.event.StatusUpdate
import com.company.event.complexaction.ComplexAction
import com.company.simmap.SimMap

class Metabolize(private val auto: Automaton) : ComplexAction {

    companion object {
        const val metabolizeAmount = 1.0
    }

    override fun execute(simMap: SimMap): List<Action> {
        return listOf(
                StatusUpdate(
                        auto.getStatus(),
                        Status.StatusChange(0.0, -metabolizeAmount)
                )
        )
    }

}