package com.company.automaton

import com.company.action.*
import com.company.action.Heal
import com.company.action.PhotoSynth
import com.company.action.ReproduceAction

class PlantAutomaton : AutomatonImpl(Status.createDefault()) {

    override fun tick(): SimAction {
        if (getStatus().health < 80 && getStatus().health < getStatus().energy && getStatus().energy > 40) {
            return Heal(this.getStatus())
        }
        if (getStatus().health > 60 && getStatus().energy > 60) {
            return ReproduceAction(this) {PlantAutomaton()}
        }
        return PhotoSynth(this)
    }

}
