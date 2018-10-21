package com.company.action

import com.company.ActionExecutor
import com.company.automaton.TestAutomaton
import com.company.simmap.Loc
import com.company.simmap.SimMapGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PlaceAutoTest {

    private val simMap = SimMapGenerator().generateEmptyMap(10, 10)
    private val location = Loc(5, 5)

    @Test
    fun placesAutoWhenCellIsEmpty() {
        val auto = TestAutomaton()
        ActionExecutor().executeAction(simMap, PlaceAuto(auto, location))
        assertEquals(auto, simMap.getAutomaton(location))
    }

    @Test
    fun doesNotPlaceAutoWhenCellIsNotEmpty() {
        val prevAuto = TestAutomaton()
        simMap.addAutomaton(location, prevAuto)
        val autoToPlace = TestAutomaton()
        ActionExecutor().executeAction(simMap, PlaceAuto(autoToPlace, location))
        assertEquals(prevAuto, simMap.getAutomaton(location))
    }

}