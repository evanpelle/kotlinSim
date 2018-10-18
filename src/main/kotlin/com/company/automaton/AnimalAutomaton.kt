package com.company.automaton

import com.company.action.*

class AnimalAutomaton: AutomatonImpl(Status.createDefault()) {

    override fun tick(): SimAction {
        println("health ${getStatus().health}, energy ${getStatus().energy}")
        if (getStatus().energy < 50) {
            return Rest(this)
        }
        if (getStatus().health > 40) {
            return AttackRandomNeighbor(this)
        }
        return DoNothing()
    }

}