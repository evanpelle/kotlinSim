package com.company.simmap

import kotlin.math.abs

data class Loc(val x: Int, val y: Int) {

    constructor(base: Loc) : this(base.x, base.y)

    fun getDirection(other: Loc): Direction? {
        return Direction.values().find { getNeighbor(it) == other }
    }

    fun isNeighbor(other: Loc): Boolean {
        return getNeighbors().contains(other)
    }

    fun getNeighbors(): List<Loc> {
        return Direction.values().map { getNeighbor(it) }
    }

    fun getNeighbor(direction: Direction): Loc {
        return when (direction) {
            Direction.NORTH -> Loc(x, y - 1)
            Direction.SOUTH -> Loc(x, y + 1)
            Direction.EAST -> Loc(x + 1, y)
            Direction.WEST -> Loc(x - 1, y)
        }
    }

    fun getDistance(other: Loc): Int {
        return abs(x - other.x) + abs(y - other.y)
    }

    override fun toString(): String {
        return "[x: $x, y: $y]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Loc

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
