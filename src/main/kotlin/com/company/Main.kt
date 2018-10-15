package com.company

import com.company.simmap.SimMapGenerator

fun main(args: Array<String>) {
    val simMap = SimMapGenerator().generateDefaultMap()
    val simRunner = SimRunner()
    val simMapPrinter = SimMapPrinter()

    for (i in 0..9) {
        simRunner.tick(simMap)
        println(simMapPrinter.getSimMapRepr(simMap))
        try {
            Thread.sleep(500)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println(simMapPrinter.clearTerminal(simMap))
    }
}
