package com.company.automaton

class Attributes(maxHealth: Double, maxEnergy: Double, strength: Double) {

    val maxHealth: Double
    val maxEnergy: Double
    val strength: Double

    init {
        val total = maxHealth + maxEnergy + strength
        val multiplier = 3 * 100.0
        this.maxHealth = multiplier * maxHealth / total
        this.maxEnergy = multiplier * maxEnergy / total
        this.strength = multiplier * strength / total
    }

    companion object {

        fun createDefault(): Attributes {
            return Attributes(100.0, 100.0, 100.0)
        }

    }

}