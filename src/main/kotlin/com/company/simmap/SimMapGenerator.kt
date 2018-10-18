package com.company.simmap

import com.company.automaton.DoNothingAuto
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
        simMap.addAutomaton(Location(3, 3), PlantAutomaton())
        simMap.addAutomaton(Location(7, 7), AnimalAutomaton())
        simMap.addAutomaton(Location(6, 6), DoNothingAuto())
        return simMap
    }

}
