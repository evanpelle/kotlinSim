package com.company.action

import com.company.GameAttributes
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DoNothingTest {

    @Test
    fun doNothingReturnsEmptyActions() {
        assertThat(DoNothing().execute(GameAttributes.default(), SimMap(10, 10))).isEmpty()
    }

}