package com.company.event

import com.company.simmap.SimMap

interface BasicEvent : Event {

    fun execute(simMap: SimMap)

}