package com.company.simmap

import com.company.automaton.Automaton

class SimMap(val width: Int, val height: Int) {

    private val map: Array<Array<Automaton?>> = Array(width) { arrayOfNulls<Automaton>(height) }

    private val automatonToLocationMap: MutableMap<Automaton, Location> = mutableMapOf()

    fun getRandomEmptyNeighbor(loc: Location): Location? {
        val emptyNeighborLocations = getEmptyNeighborLocations(loc)
        if (emptyNeighborLocations.isNotEmpty()) {
            return emptyNeighborLocations[(Math.random() * emptyNeighborLocations.size).toInt()]
        }
        return null
    }

    fun getRandomNeighborWithAuto(loc: Location): Location? {
        val neighborsWithAutos = loc.getNeighbors().filter { containsAuto(it) }
        if (neighborsWithAutos.isNotEmpty()) {
            return neighborsWithAutos[(Math.random() * neighborsWithAutos.size).toInt()]
        }
        return null
    }

    fun getEmptyNeighborLocations(loc: Location): List<Location> {
        return loc.getNeighbors().filter { canMoveOn(it) }
    }

    fun addAutomaton(loc: Location, auto: Automaton): Boolean {
        if (isOnMap(loc) && isEmpty(loc) && !automatonToLocationMap.contains(auto)) {
            map[loc.x][loc.y] = auto
            automatonToLocationMap[auto] = loc
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

    fun removeAutomaton(auto: Automaton): Boolean {
        val loc = getLocation(auto)
        if (loc != null) {
            removeAutomaton(loc)
            return true
        }
        return false
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

    fun containsAuto(loc: Location): Boolean {
        return isOnMap(loc) && !isEmpty(loc)
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
