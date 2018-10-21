package com.company.simmap

import com.company.automaton.Automaton

class SimMap(val width: Int, val height: Int) {

    private val map: Array<Array<Automaton?>> = Array(width) { arrayOfNulls<Automaton>(height) }

    private val automatonToLocMap: MutableMap<Automaton, Loc> = mutableMapOf()

    fun getRandomEmptyNeighbor(loc: Loc): Loc? {
        val emptyNeighborLocations = getEmptyNeighborLocations(loc)
        if (emptyNeighborLocations.isNotEmpty()) {
            return emptyNeighborLocations[(Math.random() * emptyNeighborLocations.size).toInt()]
        }
        return null
    }

    fun getRandomNeighborWithAuto(loc: Loc): Loc? {
        val neighborsWithAutos = loc.getNeighbors().filter { containsAuto(it) }
        if (neighborsWithAutos.isNotEmpty()) {
            return neighborsWithAutos[(Math.random() * neighborsWithAutos.size).toInt()]
        }
        return null
    }

    fun getEmptyNeighborLocations(loc: Loc): List<Loc> {
        return loc.getNeighbors().filter { canMoveOn(it) }
    }

    fun addAutomaton(loc: Loc, auto: Automaton): Boolean {
        if (isOnMap(loc) && isEmpty(loc) && !automatonToLocMap.contains(auto)) {
            map[loc.x][loc.y] = auto
            automatonToLocMap[auto] = loc
            return true
        }
        return false
    }

    fun removeAutomaton(loc: Loc): Automaton? {
        if (!isOnMap(loc)) {
            return null
        }
        val toRemove = this.getAutomaton(loc)
        map[loc.x][loc.y] = null
        automatonToLocMap.remove(toRemove)
        return toRemove
    }

    fun removeAutomaton(auto: Automaton): Boolean {
        val loc = getLocation(auto)
        if (loc != null) {
            removeAutomaton(loc)
            return true
        }
        return false
    }

    fun getAutomaton(loc: Loc): Automaton? {
        if (isOnMap(loc)) {
            return map[loc.x][loc.y]
        }
        return null
    }

    fun getAutomatons(): Set<Automaton> {
        return automatonToLocMap.keys.toSet()
    }

    fun canMoveOn(loc: Loc): Boolean {
        return isOnMap(loc) && isEmpty(loc)
    }

    // TODO: throw exception if not on map
    fun isEmpty(loc: Loc): Boolean {
        return isOnMap(loc) && getAutomaton(loc) == null
    }

    fun containsAuto(loc: Loc): Boolean {
        return isOnMap(loc) && !isEmpty(loc)
    }

    fun isOnMap(loc: Loc): Boolean {
        return loc.x >= 0 && loc.y >= 0 && loc.x < width && loc.y < height
    }

    fun isOnMap(auto: Automaton): Boolean {
        return automatonToLocMap.containsKey(auto)
    }

    fun getLocation(auto: Automaton): Loc? {
        return automatonToLocMap.get(auto)
    }

}
