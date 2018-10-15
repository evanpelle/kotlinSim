package test.com.company.simmap

import com.company.simmap.Direction
import com.company.simmap.Location
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test

internal class LocationTest {

    @Test
    fun distanceReturnsOneWhenLocationsAreOneXApart() {
        assertEquals(1, Location(1,1).getDistance(Location(2, 1)))
    }

    @Test
    fun distanceReturnsZeroWhenLocationsAreTheSame() {
        assertEquals(0, Location(1,1).getDistance(Location(1,1)))
    }

    @Test
    fun distanceReturnsTwoWhenLocationsAreDiagonal() {
        assertEquals(2, Location(0, 0).getDistance(Location(1, 1)))
    }

    @Test
    fun getDirectionReturnsNorthWhenOtherLocationIsNorth() {
        assertEquals(Direction.NORTH, Location(0, 1).getDirection(Location(0, 0)))
    }

    @Test
    fun getDirectionReturnsNullWhenOtherLocationIsMoreThanOneSpaceAway() {
        assertNull(Location(0, 0).getDirection(Location(10, 10)))
    }

}