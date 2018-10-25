package com.company.automaton

import com.company.event.complexaction.*
import com.company.event.basicaction.Heal
import com.company.event.complexaction.PhotoSynth
import com.company.event.basicaction.Reproduce

class PlantAutomaton : AutomatonImpl(Status.createDefault()) {

    override fun tick(): ComplexAction {
        if (getStatus().health < 80 && getStatus().health < getStatus().energy && getStatus().energy > 40) {
            return Heal(this.getStatus())
        }
        if (getStatus().health > 60 && getStatus().energy > 60) {
            return Reproduce(this) { PlantAutomaton() }
        }
        return PhotoSynth(this)
    }

}
