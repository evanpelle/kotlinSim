package com.company.event

import com.company.simmap.SimMap

interface Event {

    fun execute(simMap: SimMap)

}