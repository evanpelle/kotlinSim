package com.company.simmap

import com.company.automaton.Automaton

class SimMap(val width: Int, val height: Int) {

    private val map: Array<Array<Automaton?>> = Array(width) { arrayOfNulls<Automaton>(height) }

    private val automatonToLocationMap: MutableMap<Automaton, Location> = mutableMapOf()

    fun addAutomaton(loc: Location, auto: Automaton): Boolean {
        if (isOnMap(loc) && isEmpty(loc) && !automatonToLocationMap.contains(auto)) {
            map[loc.x][loc.y] = auto
            automatonToLocationMap.put(auto, loc)
            return true
        }
        return false
    }

    fun removeAutomaton(loc: Location): Automaton? {
        if (!isOnMap(loc)) {
            return null
        }
        val toRemove = this.getAutomaton(loc)
        map[loc.x][loc.y] = null
        automatonToLocationMap.remove(toRemove)
        return toRemove
    }

    fun getAutomaton(loc: Location): Automaton? {
        if (isOnMap(loc)) {
            return map[loc.x][loc.y]
        }
        return null
    }

    fun getAutomatons(): Set<Automaton> {
        return automatonToLocationMap.keys.toSet()
    }

    fun canMoveOn(loc: Location): Boolean {
        return isOnMap(loc) && isEmpty(loc)
    }

    // TODO: throw exception if not on map
    fun isEmpty(loc: Location): Boolean {
        return isOnMap(loc) && getAutomaton(loc) == null
    }

    fun isOnMap(loc: Location): Boolean {
        return loc.x >= 0 && loc.y >= 0 && loc.x < width && loc.y < height
    }

    fun isOnMap(auto: Automaton): Boolean {
        return automatonToLocationMap.containsKey(auto)
    }

    fun getLocation(auto: Automaton): Location? {
        return automatonToLocationMap.get(auto)
    }

}
