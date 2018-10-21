package com.company.automaton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttributesTest {

    @Test
    fun attributesAreAll100IfSetTo100() {
        val attributes = Attributes(100.0, 100.0, 100.0)
        verifyAttributes(attributes, 100.0, 100.0, 100.0)
    }

    @Test
    fun attributesAreAll100IfSetTo1() {
        val attributes = Attributes(1.0, 1.0, 1.0)
        verifyAttributes(attributes, 100.0, 100.0, 100.0)
    }

    @Test
    fun oneAttributeAt300IfOnlyOneNonzero() {
        val attributes = Attributes(1.0, 0.0, 0.0)
        verifyAttributes(attributes, 300.0, 0.0, 0.0)
    }

    @Test
    fun twoAddUpTo300IfOnly2Nonzero() {
        val attributes = Attributes(1.0, 1.0, 0.0)
        verifyAttributes(attributes, 150.0, 150.0, 0.0)
    }

    private fun verifyAttributes(actualAttributes: Attributes,
                                 expectedMaxHealth: Double,
                                 expectedMaxEnergy: Double,
                                 expectedStrength: Double) {

        assertThat(actualAttributes.maxHealth).isEqualTo(expectedMaxHealth)
        assertThat(actualAttributes.maxEnergy).isEqualTo(expectedMaxEnergy)
        assertThat(actualAttributes.strength).isEqualTo(expectedStrength)
    }

}