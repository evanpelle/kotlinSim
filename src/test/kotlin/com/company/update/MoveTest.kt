package com.company.update

import com.company.action.Move
import com.company.automaton.TestAutomaton
import com.company.simmap.Direction
import com.company.simmap.Location
import com.company.simmap.SimMap
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import junit.framework.TestCase.assertFalse
import org.junit.Test

internal class MoveTest {

    private val startLocation = Location(1, 1)
    private val auto = TestAutomaton()
    private val simMap = SimMap(10, 10)

    @Test
    fun autoDoesNotMoveIfNotOnMap() {
        Move(auto, Direction.WEST).performAction(simMap)
        assertFalse(simMap.isOnMap(auto))
    }

    @Test
    fun autoDoesNotMoveIfEnergyBelow30() {
        auto.getStatus().energy = 25.0
        simMap.addAutomaton(startLocation, auto)
        Move(auto, Direction.WEST).performAction(simMap)
        assertTrue(simMap.isEmpty(Location(0, 1)))
    }

    @Test
    fun autoDoesNotMoveIfTargetLocationIsNotEmpty() {
        simMap.addAutomaton(startLocation, auto)
        simMap.addAutomaton(Location(0, 1), TestAutomaton())
        Move(auto, Direction.WEST).performAction(simMap)
        assertEquals(startLocation, simMap.getLocation(auto))
    }

    @Test
    fun autoMovesIfAllowed() {
        simMap.addAutomaton(startLocation, auto)
        val targetLocation = Location(0, 1)
        Move(auto, Direction.WEST).performAction(simMap)
        assertEquals(targetLocation, simMap.getLocation(auto))
    }

}