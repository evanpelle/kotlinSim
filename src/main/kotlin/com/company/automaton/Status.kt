package com.company.automaton

import kotlin.math.max
import kotlin.math.min

class Status(val attributes: Attributes,
             health: Double,
             energy: Double) {

    var health = 0.0
        set(value) {
            field = inRange(0.0, value, attributes.maxHealth)
        }

    var energy = 0.0
        set(value) {
            field = inRange(0.0, value, attributes.maxEnergy)
        }

    init {
        this.health = health
        this.energy = energy
    }

    companion object Factory {

        fun createDefault(): Status = Status(Attributes(1.0, 1.0, 1.0), 100.0, 100.0)
        fun fullStatus(attributes: Attributes): Status = Status(attributes, attributes.maxHealth, attributes.maxEnergy)

    }

    fun isDead(): Boolean {
        return health <= 0.0
    }

    fun update(change: StatusChange) {
        energy += change.energyChange
        health += change.healthChange
    }

    private fun inRange(minVal: Double, valueToSet: Double, maxVal: Double): Double {
        return min(maxVal, max(minVal, valueToSet))
    }

    data class StatusChange(val healthChange: Double, val energyChange: Double)

}