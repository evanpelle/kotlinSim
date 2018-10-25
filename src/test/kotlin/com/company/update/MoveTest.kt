package com.company.update

import com.company.ActionExecutor
import com.company.event.basicaction.Move
import com.company.automaton.TestAutomaton
import com.company.simmap.Direction
import com.company.simmap.Loc
import com.company.simmap.SimMap
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MoveTest {

    private val executor = ActionExecutor()
    private val simMap = SimMap(10, 10)
    private val startLocation = Loc(1, 1)
    private val auto = TestAutomaton()

    @Test
    fun autoDoesNotMoveIfNotOnMap() {
        Move(auto, Direction.WEST).execute(simMap)
        assertFalse(simMap.isOnMap(auto))
    }

    @Test
    fun autoDoesNotMoveIfEnergyBelow30() {
        auto.getStatus().energy = 25.0
        simMap.addAutomaton(startLocation, auto)
        executor.executeActions(simMap, Move(auto, Direction.WEST).execute(simMap))
        assertTrue(simMap.isEmpty(Loc(0, 1)))
    }

    @Test
    fun autoDoesNotMoveIfTargetLocationIsNotEmpty() {
        simMap.addAutomaton(startLocation, auto)
        simMap.addAutomaton(Loc(0, 1), TestAutomaton())
        executor.executeActions(simMap, Move(auto, Direction.WEST).execute(simMap))
                assertEquals (startLocation, simMap.getLocation(auto))
    }

    @Test
    fun autoMovesIfAllowed() {
        simMap.addAutomaton(startLocation, auto)
        executor.executeActions(simMap, Move(auto, Direction.WEST).execute(simMap))
        assertEquals(Loc(0, 1), simMap.getLocation(auto))
    }

}