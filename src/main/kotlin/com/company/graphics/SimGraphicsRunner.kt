package com.company.graphics

import com.company.ActionExecutor
import com.company.SimRunner
import com.company.simmap.SimMapGenerator

fun main(args: Array<String>) {
    val simMap = SimMapGenerator().generateDefaultMap()
    val simRunner = SimRunner(ActionExecutor())
    val simGraphics = SimGraphics(simMap)

    for (i in 0..100000000) {
//        println("tick")
        simRunner.tick(simMap)
        if (i % 10 == 0) {
            simGraphics.repaint()
        }
        try {
            Thread.sleep(10)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}