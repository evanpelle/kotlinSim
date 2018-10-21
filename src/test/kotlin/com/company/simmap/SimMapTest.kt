package com.company.simmap

import com.company.automaton.TestAutomaton
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SimMapTest {

    private val simMap = SimMap(10, 10)
    private val auto = TestAutomaton()

    @Test
    fun isOnMapReturnsTrueIfLocationIsOnMap() {
        assertTrue(simMap.isOnMap(Loc(1, 1)))
    }

    @Test
    fun isOnMapReturnsFalseIfLocationIsNotOnMap() {
        assertFalse(simMap.isOnMap(Loc(11, 11)))
    }

    @Test
    fun addAutomatonReturnsTrueIfSuccessful() {
        assertTrue(simMap.addAutomaton(Loc(1, 1), auto))
    }

    @Test
    fun addAutomatonReturnsFalseIfNotSuccessful() {
        assertFalse(simMap.addAutomaton(Loc(11,11), auto))
    }

    @Test
    fun isEmptyReturnsTrueIfCellEmpty() {
        assertTrue(simMap.isEmpty(Loc(1,1)))
    }

    @Test
    fun isEmptyReturnsFalseIsCellNotEmpty() {
        simMap.addAutomaton(Loc(1,1), auto)
        assertFalse(simMap.isEmpty(Loc(1,1)))
    }

    @Test
    fun getAutomatonReturnsAutomatonIfThereIsOneAtLocation() {
        simMap.addAutomaton(Loc(1, 1), auto)
        assertEquals(auto, simMap.getAutomaton(Loc(1, 1)))
    }

    @Test
    fun getAutomatonReturnsNullIfThereIsNoneAtLocation() {
        simMap.addAutomaton(Loc(1, 1), auto)
        assertNull(simMap.getAutomaton(Loc(2, 2)))
    }

    @Test
    fun getAutomatonReturnsNullIfLocationIsNotOnMap() {
        assertNull(simMap.getAutomaton(Loc(11, 11)))
    }

    @Test
    fun removeAutomatonReturnsNullIfLocationNotOnMap() {
        assertNull(simMap.removeAutomaton(Loc(11, 11)))
    }

    @Test
    fun removeAutomatonReturnsNullIfCellIsEmpty() {
        assertNull(simMap.removeAutomaton(Loc(1, 1)))
    }

    @Test
    fun removeAutomatonReturnsAutomatonIfInCell() {
        simMap.addAutomaton(Loc(1, 1), auto)
        assertEquals(auto, simMap.getAutomaton(Loc(1, 1)))
    }

    @Test
    fun removeAutomatonRemovesAutomatonFromMap() {
        simMap.addAutomaton(Loc(1,1), auto)
        simMap.removeAutomaton(Loc(1,1))
        assertTrue(simMap.isEmpty(Loc(1, 1)))
    }

    @Test
    fun getLocationReturnsNullIfAutomatonNotInMap() {
        assertNull(simMap.getLocation(auto))
    }

    @Test
    fun getLocationReturnsLocationIfAutomatonInMap() {
        val loc = Loc(1, 1)
        simMap.addAutomaton(loc, auto)
        assertEquals(loc, simMap.getLocation(auto))
    }

    // TODO

//    @Test
//    fun getLocalMapReturnsMapOfCorrectSize() {
//        val localMap = simMap.getLocalMap(Loc(5, 5), 1)
//        assertThat(localMap.height).isEqualTo(1)
//        assertThat(localMap.width).isEqualTo(1)
//    }
//
//    @Test
//    fun localMapContainsAutos() {
//        simMap.addAutomaton(Loc(1, 1), auto)
//        val localMap = simMap.getLocalMap(Loc(1, 1), 1)
//        assertThat(localMap.getAutomaton(Loc(0, 0))).isEqualTo(auto)
//        assertThat(localMap.getAutomatons()).containsOnly(auto)
//    }

}
