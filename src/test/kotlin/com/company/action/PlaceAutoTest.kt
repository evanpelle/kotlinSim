package com.company.action

import com.company.automaton.TestAutomaton
import com.company.simmap.Location
import com.company.simmap.SimMapGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PlaceAutoTest {

    private val simMap = SimMapGenerator().generateEmptyMap(10, 10)

    private val location = Location(5, 5)

    @Test
    fun placesAutoWhenCellIsEmpty() {
        val auto = TestAutomaton()
        PlaceAuto(auto, location).performAction(simMap)
        assertEquals(auto, simMap.getAutomaton(location))
    }

    @Test
    fun doesNotPlaceAutoWhenCellIsNotEmpty() {
        val prevAuto = TestAutomaton()
        simMap.addAutomaton(location, prevAuto)
        val autoToPlace = TestAutomaton()
        PlaceAuto(autoToPlace, location).performAction(simMap)
        assertEquals(prevAuto, simMap.getAutomaton(location))
    }

}