package com.company.simmap

import com.company.automaton.AnimalAutomaton
import com.company.automaton.PlantAutomaton

class SimMapGenerator {

    fun generateEmptyMap(width: Int, height: Int): SimMap {
        return SimMap(width, height)
    }

    fun generateDefaultMap(): SimMap {
        val width = 30
        val height = 30
        val simMap = SimMap(width, height)
        simMap.addAutomaton(Loc(0, 0), AnimalAutomaton())
        simMap.addAutomaton(Loc(0, 1), PlantAutomaton())
        simMap.addAutomaton(Loc(1, 0), PlantAutomaton())
        simMap.addAutomaton(Loc(1, 1), PlantAutomaton())

        simMap.addAutomaton(Loc(3, 3), PlantAutomaton())
        simMap.addAutomaton(Loc(3, 4), PlantAutomaton())
        simMap.addAutomaton(Loc(12, 8), PlantAutomaton())
        simMap.addAutomaton(Loc(5, 4), PlantAutomaton())
        simMap.addAutomaton(Loc(5, 5), PlantAutomaton())
        simMap.addAutomaton(Loc(4, 5), PlantAutomaton())
        simMap.addAutomaton(Loc(4, 4), AnimalAutomaton())
        simMap.addAutomaton(Loc(2, 2), AnimalAutomaton())
        simMap.addAutomaton(Loc(10, 10), AnimalAutomaton())
        simMap.addAutomaton(Loc(11, 10), PlantAutomaton())
        simMap.addAutomaton(Loc(9, 10), PlantAutomaton())
        simMap.addAutomaton(Loc(9, 11), PlantAutomaton())


        return simMap
    }

    fun generateLargeMap(): SimMap {
        val simMap = SimMap(100, 100)
        simMap.addAutomaton(Loc(50, 50), PlantAutomaton())
        return simMap
    }

}
