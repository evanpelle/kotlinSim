package com.company.event

import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InsertTest {

    val simMap = SimMap(10, 10)

    @Test
    fun insertAddsAutoWhenPositionIsEmptyAndOnMap() {
        val testAutomaton = TestAutomaton()
        Insert(Loc(5, 5), testAutomaton).execute(simMap)
        assertThat(simMap.getAutomaton(Loc(5, 5))).isEqualTo(testAutomaton)
    }

    @Test
    fun insertDoesNotInsertIfAutoCannotMoveOnLocation() {
        val prevAuto = TestAutomaton()
        Insert(Loc(5, 5), prevAuto).execute(simMap)
        val newAuto = TestAutomaton()
        Insert(Loc(5, 5), newAuto).execute(simMap)
        assertThat(simMap.getAutomaton(Loc(5, 5))).isEqualTo(prevAuto)
    }

}