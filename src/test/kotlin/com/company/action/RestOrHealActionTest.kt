package com.company.action

import com.company.automaton.Status
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RestOrHealActionTest {

    private val simMap = SimMap(10, 10)

    @Test
    fun actionInvalidAndDoesNothingWhenEnergyAndHealthAreAboveThreshold() {
        val action = RestOrHealAction(Status.createDefault())
        assertThat(action.isValid()).isFalse()
    }

    @Test
    fun actionValidWhenHealthBelowThreshold() {
        val status = Status.createDefault()
        status.health = 10.0
        val action = RestOrHealAction(status)
        assertThat(action.isValid()).isTrue()
    }

    @Test
    fun actionValidWhenEnergyBelowThreshold() {
        val status = Status.createDefault()
        status.energy = 10.0
        val action = RestOrHealAction(status)
        assertThat(action.isValid()).isTrue()
    }

    @Test
    fun actionNotValidWhenBothAreBelowThreshold() {
        val status = Status.createDefault()
        status.energy = 10.0
        status.health = 10.0
        val action = RestOrHealAction(status)
        assertThat(action.isValid()).isFalse()
    }

    @Test
    fun actionReturnsHealWhenHealthBelowThreshold() {
        val status = Status.createDefault()
        status.health = 10.0
        assertThat(RestOrHealAction(status).execute(simMap)).containsOnly(
                Heal(status)
        )
    }

    @Test
    fun actionReturnsRestWhenEnergyBelowThreshold() {
        val status = Status.createDefault()
        status.energy = 10.0
        assertThat(RestOrHealAction(status).execute(simMap)).containsOnly(
                Rest(status)
        )
    }

    @Test
    fun actionsDoesNothingWhenHealthAndEnergyAreAboveThreshold() {
        val status = Status.createDefault()
        status.health = 10.0
        status.energy = 10.0
        assertThat(RestOrHealAction(status).execute(simMap)).isEmpty()
    }

}