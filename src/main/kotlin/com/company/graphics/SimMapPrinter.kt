package com.company.graphics

import com.company.simmap.Location
import com.company.simmap.SimMap

class SimMapPrinter {

    fun getSimMapRepr(simMap: SimMap): String {
        val sb = StringBuilder()
        sb.append(createBorder(simMap))
        for (y in 0 until simMap.height) {
            for (x in 0 until simMap.width) {
                val auto = simMap.getAutomaton(Location(x,y))
                if (auto != null) {
                    sb.append("p")
                } else {
                    sb.append(' ')
                }
            }
            sb.append('\n')
        }
        sb.append(createBorder(simMap))
        return sb.toString()
    }

    fun clearTerminal(simMap: SimMap): String {
        val sb = StringBuilder()
        for (y in 0 until simMap.height) {
            for (x in 0 until simMap.width) {
                sb.append(' ')
            }
            sb.append('\n')
        }
        return sb.toString()
    }

    private fun createBorder(simMap: SimMap): String {
        val sb = StringBuilder()
        for (i in 0 until simMap.width) {
            sb.append("- ")
        }
        return sb.toString()
    }

}
