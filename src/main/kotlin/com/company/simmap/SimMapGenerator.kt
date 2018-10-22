package com.company.simmap

import com.company.automaton.AnimalAutomaton
import com.company.automaton.PlantAutomaton

class SimMapGenerator {

    fun generateEmptyMap(width: Int, height: Int): SimMap {
        return SimMap(width, height)
    }

    fun generateDefaultMap(): SimMap {
        val width = 10
        val height = 10
        val simMap = SimMap(width, height)
        simMap.addAutomaton(Loc(3, 3), PlantAutomaton())
        simMap.addAutomaton(Loc(4, 4), AnimalAutomaton())
        return simMap
    }

    fun generateLargeMap(): SimMap {
        val simMap = SimMap(100, 100)
        simMap.addAutomaton(Loc(50, 50), PlantAutomaton())
        return simMap
    }

}
