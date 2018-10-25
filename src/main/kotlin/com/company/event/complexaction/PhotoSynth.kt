package com.company.event.complexaction

import com.company.automaton.Automaton
import com.company.automaton.Status
import com.company.event.Action
import com.company.event.StatusUpdate
import com.company.simmap.SimMap

class PhotoSynth(private val auto: Automaton) : ComplexAction {

    companion object {
        const val energyGained = 5.0
    }

    override fun execute(simMap: SimMap): List<Action> {
        return listOf(
                StatusUpdate(
                        auto.getStatus(),
                        Status.StatusChange(0.0, energyGained)
                )
        )
    }

}
