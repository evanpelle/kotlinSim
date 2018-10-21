package com.company.graphics

import com.company.ActionExecutor
import com.company.GameAttributes
import com.company.SimRunner
import com.company.simmap.SimMapGenerator

fun main(args: Array<String>) {
    val gameAttributes = GameAttributes.default()
    val simMap = SimMapGenerator().generateDefaultMap()
    val simRunner = SimRunner(ActionExecutor())
    val simGraphics = SimGraphics(simMap)

    for (i in 0..150) {
        println("tick")
        simRunner.tick(gameAttributes, simMap)
        simGraphics.repaint()
        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}