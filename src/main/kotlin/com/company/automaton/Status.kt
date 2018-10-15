package com.company.automaton

class Status(val maxEnergy: Double,
             val maxHealth: Double,
             var energy: Double,
             var health: Double) {

    companion object Factory {

        fun createDefault(): Status = Status(100.0, 100.0, 100.0, 100.0)

    }

}