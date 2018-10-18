package com.company.automaton

import com.company.action.*

class PlantAutomaton : AutomatonImpl(Status.createDefault()) {

    override fun tick(): SimAction {
        if (getStatus().health < 80 && getStatus().health < getStatus().energy && getStatus().energy > 40) {
            return Heal(this)
        }
        if (getStatus().health > 60 && getStatus().energy > 60) {
            return ReproduceAction(this, PlantAutomaton())
        }
        return PhotoSynth(this)
    }

}
