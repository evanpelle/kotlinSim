package com.company.simmap

import kotlin.math.abs

data class Location(val x: Int, val y: Int) {

    constructor(base: Location) : this(base.x, base.y)

    fun getDirection(other: Location): Direction? {
        return Direction.values().find { getNeighbor(it) == other }
    }

    fun isNeighbor(other: Location): Boolean {
        return getNeighbors().contains(other)
    }

    fun getNeighbors(): List<Location> {
        return Direction.values().map { getNeighbor(it) }
    }

    fun getNeighbor(direction: Direction): Location {
        return when (direction) {
            Direction.NORTH -> Location(x, y - 1)
            Direction.SOUTH -> Location(x, y + 1)
            Direction.EAST -> Location(x + 1, y)
            Direction.WEST -> Location(x - 1, y)
        }
    }

    fun getDistance(other: Location): Int {
        return abs(x - other.x) + abs(y - other.y)
    }

    override fun toString(): String {
        return "[x: $x, y: $y]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Location

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }


}
