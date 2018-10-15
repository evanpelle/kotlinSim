package com.company.simmap

import com.company.automaton.TestAutomaton
import junit.framework.Assert.assertFalse
import junit.framework.TestCase.*
import org.junit.Test

internal class SimMapTest {

    private val simMap = SimMap(10, 10)
    private val auto = TestAutomaton()

    @Test
    fun isOnMapReturnsTrueIfLocationIsOnMap() {
        assertTrue(simMap.isOnMap(Location(1, 1)))
    }

    @Test
    fun isOnMapReturnsFalseIfLocationIsNotOnMap() {
        assertFalse(simMap.isOnMap(Location(11, 11)))
    }

    @Test
    fun addAutomatonReturnsTrueIfSuccessful() {
        assertTrue(simMap.addAutomaton(Location(1, 1), auto))
    }

    @Test
    fun addAutomatonReturnsFalseIfNotSuccessful() {
        assertFalse(simMap.addAutomaton(Location(11,11), auto))
    }

    @Test
    fun isEmptyReturnsTrueIfCellEmpty() {
        assertTrue(simMap.isEmpty(Location(1,1)))
    }

    @Test
    fun isEmptyReturnsFalseIsCellNotEmpty() {
        simMap.addAutomaton(Location(1,1), auto)
        assertFalse(simMap.isEmpty(Location(1,1)))
    }

    @Test
    fun getAutomatonReturnsAutomatonIfThereIsOneAtLocation() {
        simMap.addAutomaton(Location(1, 1), auto)
        assertEquals(auto, simMap.getAutomaton(Location(1, 1)))
    }

    @Test
    fun getAutomatonReturnsNullIfThereIsNoneAtLocation() {
        simMap.addAutomaton(Location(1, 1), auto)
        assertNull(simMap.getAutomaton(Location(2, 2)))
    }

    @Test
    fun getAutomatonReturnsNullIfLocationIsNotOnMap() {
        assertNull(simMap.getAutomaton(Location(11, 11)))
    }

    @Test
    fun removeAutomatonReturnsNullIfLocationNotOnMap() {
        assertNull(simMap.removeAutomaton(Location(11, 11)))
    }

    @Test
    fun removeAutomatonReturnsNullIfCellIsEmpty() {
        assertNull(simMap.removeAutomaton(Location(1, 1)))
    }

    @Test
    fun removeAutomatonReturnsAutomatonIfInCell() {
        simMap.addAutomaton(Location(1, 1), auto)
        assertEquals(auto, simMap.getAutomaton(Location(1, 1)))
    }

    @Test
    fun removeAutomatonRemovesAutomatonFromMap() {
        simMap.addAutomaton(Location(1,1), auto)
        simMap.removeAutomaton(Location(1,1))
        assertTrue(simMap.isEmpty(Location(1, 1)))
    }

    @Test
    fun getLocationReturnsNullIfAutomatonNotInMap() {
        assertNull(simMap.getLocation(auto))
    }

    @Test
    fun getLocationReturnsLocationIfAutomatonInMap() {
        val loc = Location(1, 1)
        simMap.addAutomaton(loc, auto)
        assertEquals(loc, simMap.getLocation(auto))
    }

}
