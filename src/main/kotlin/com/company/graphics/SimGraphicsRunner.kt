package com.company.graphics

import com.company.SimRunner
import com.company.simmap.SimMapGenerator

fun main(args: Array<String>) {
    val simMap = SimMapGenerator().generateDefaultMap()
    val simRunner = SimRunner()
    val simGraphics = SimGraphics(simMap)

    for (i in 0..150) {
        println("tick")
        simRunner.tick(simMap)
        simGraphics.repaint()
        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}