package com.company

data class GameAttributes(
        val metabolizeAmount: Double,
        val healEnergyRequired: Double,
        val healHealthGained: Double,
        val restEnergyGained: Double,
        val restHealthRequired: Double,
        val attackEnergy: Double,
        val moveEnergy: Double,
        val moveEnergyReserve: Double,
        val photoSynthEnergyGain: Double,
        val reproduceHealthCost: Double,
        val reproduceEnergyCost: Double
) {

    companion object {

        fun default(): GameAttributes {
            return GameAttributes(
                    metabolizeAmount = 1.0,
                    healEnergyRequired = 25.0,
                    healHealthGained = 5.0,
                    restEnergyGained = 20.0,
                    restHealthRequired = 5.0,
                    attackEnergy = 40.0,
                    moveEnergy = 30.0,
                    moveEnergyReserve = 20.0,
                    photoSynthEnergyGain = 5.0,
                    reproduceHealthCost = 50.0,
                    reproduceEnergyCost = 50.0
            )
        }

    }

}