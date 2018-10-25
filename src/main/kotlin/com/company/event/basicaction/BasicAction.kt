package com.company.event.basicaction

import com.company.event.Action
import com.company.simmap.SimMap

interface BasicAction : Action {

    fun execute(simMap: SimMap)

}