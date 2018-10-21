package com.company.automaton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatusTest {

    private val attributes = Attributes(
            100.0,
            100.0,
            100.0
    )

    private val status = Status(
            attributes,
            100.0,
            100.0
    )

    @Test
    fun settingHealthBelowZeroMakesItZero() {
        status.health = -10.0
        assertThat(status.health).isEqualTo(0.0)
    }

    @Test
    fun settingHealthAboveMaxHealthMakesItMakesHealth() {
        status.health = 200.0
        assertThat(status.health).isEqualTo(status.attributes.maxHealth)
    }

    @Test
    fun settingEnergyBelowZeroMakesItZero() {
        status.health = -100.0
        assertThat(status.health).isEqualTo(0.0)
    }

    @Test
    fun settingEnergyAboveMaxEnergyMakesItMaxEnergy() {
        status.energy = 5000.0
        assertThat(status.energy).isEqualTo(100.0)
    }

    @Test
    fun settingEnergyMoreThanMaxEnergyMakesItMaxEnergy() {
        val testStatus = Status(
                attributes,
                200.0,
                100.0
        )
        assertThat(testStatus.energy).isEqualTo(100.0)
    }

}