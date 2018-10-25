package com.company.automaton

import kotlin.math.max
import kotlin.math.min

data class Status(val health: Double,
                  val energy: Double) {

    fun isDead(): Boolean {
        return health <= 0.0
    }

    fun update(change: StatusChange): Status {
        return this.copy(health = this.health + change.healthChange, energy = this.energy + change.energyChange)
    }

    private fun inRange(minVal: Double, valueToSet: Double, maxVal: Double): Double {
        return min(maxVal, max(minVal, valueToSet))
    }

    data class StatusChange(val healthChange: Double, val energyChange: Double)

}