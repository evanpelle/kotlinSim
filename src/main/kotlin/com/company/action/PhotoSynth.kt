package com.company.action

import com.company.action.SimAction
import com.company.automaton.Automaton
import com.company.simmap.SimMap
import kotlin.math.min

class PhotoSynth(private val auto: Automaton) : SimAction {

    override fun performAction(simMap: SimMap) {
        auto.getStatus().energy += min(auto.getStatus().attributes.maxEnergy, auto.getStatus().energy + 5)
    }

}
