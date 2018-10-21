package com.company

import com.company.graphics.SimMapPrinter
import com.company.simmap.SimMapGenerator

fun main(args: Array<String>) {
    val gameAttributes = GameAttributes.default()
    val simMap = SimMapGenerator().generateDefaultMap()
    val simRunner = SimRunner(ActionExecutor())
    val simMapPrinter = SimMapPrinter()

    for (i in 0..9) {
        simRunner.tick(gameAttributes, simMap)
        println(simMapPrinter.getSimMapRepr(simMap))
        try {
            Thread.sleep(500)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println(simMapPrinter.clearTerminal(simMap))
    }
}
