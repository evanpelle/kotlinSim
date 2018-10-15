package com.company.simmap

import com.company.automaton.MoveAutomaton
import com.company.automaton.PlantAutomaton

class SimMapGenerator {

    fun generateDefaultMap(): SimMap {
        val width = 10
        val height = 10
        val simMap = SimMap(width, height)
//        simMap.addAutomaton(Location(3, 3), PlantAutomaton())
        simMap.addAutomaton(Location(7, 7), MoveAutomaton())
        return simMap
    }

}
