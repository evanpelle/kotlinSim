package test.com.company.simmap

import com.company.simmap.Direction
import com.company.simmap.Loc
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class LocTest {

    @Test
    fun distanceReturnsOneWhenLocationsAreOneXApart() {
        assertEquals(1, Loc(1,1).getDistance(Loc(2, 1)))
    }

    @Test
    fun distanceReturnsZeroWhenLocationsAreTheSame() {
        assertEquals(0, Loc(1,1).getDistance(Loc(1,1)))
    }

    @Test
    fun distanceReturnsTwoWhenLocationsAreDiagonal() {
        assertEquals(2, Loc(0, 0).getDistance(Loc(1, 1)))
    }

    @Test
    fun getDirectionReturnsNorthWhenOtherLocationIsNorth() {
        assertEquals(Direction.NORTH, Loc(0, 1).getDirection(Loc(0, 0)))
    }

    @Test
    fun getDirectionReturnsNullWhenOtherLocationIsMoreThanOneSpaceAway() {
        assertNull(Loc(0, 0).getDirection(Loc(10, 10)))
    }

}