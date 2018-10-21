package com.company.action

import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DoNothingTest {

    @Test
    fun doNothingReturnsEmptyActions() {
        assertThat(DoNothing().execute(SimMap(10, 10))).isEmpty()
    }

}