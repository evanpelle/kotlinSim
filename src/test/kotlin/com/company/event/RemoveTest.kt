package com.company.event

import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RemoveTest {

    private val simMap = SimMap(10, 10)

    @Test
    fun removeRemovesAutoIfOnMap() {
        val loc = Loc(3, 3)
        simMap.addAutomaton(loc, TestAutomaton())
        Remove(loc).execute(simMap)
        assertThat(simMap.isEmpty(loc)).isTrue()
    }

    @Test
    fun removeDoesNothingIfNothingOnMap() {
        val loc = Loc(3, 3)
        Remove(loc).execute(simMap)
        assertThat(simMap.isEmpty(loc)).isTrue()
    }

}