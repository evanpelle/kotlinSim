//Comment out the following package statement to compile separately.
package com.company.graphics

/**
 * Example01 illustrates some basics of Java 2D.
 * This version is compliant with Java 1.2 Beta 3, Jun 1998.
 * Please refer to: <BR></BR>
 * http://www.javaworld.com/javaworld/jw-07-1998/jw-07-media.html
 * <P>
 * @author Bill Day <bill.day></bill.day>@javaworld.com>
 * @version 1.0
 * @see java.awt.Graphics2D
</P> */

import com.company.simmap.Location
import com.company.simmap.SimMap
import org.jetbrains.annotations.NotNull
import java.awt.*
import java.awt.event.*

class SimGraphics(private val simMap: SimMap) : Frame("Java 2D Example01") {
    /**
     * Our Example01 constructor sets the frame's size, adds the
     * visual components, and then makes them visible to the user.
     * It uses an adapter class to deal with the user closing
     * the frame.
     */

    private val horizontalScale = 100
    private val verticalScale = 100

    init {

        //Set the size for the frame.
        setSize(simMap.width * horizontalScale, simMap.height * verticalScale)

        //We need to turn on the visibility of our frame
        //by setting the Visible parameter to true.
        isVisible = true

        //Now, we want to be sure we properly dispose of resources
        //this frame is using when the window is closed.  We use
        //an anonymous inner class adapter for this.
        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                dispose()
                System.exit(0)
            }
        }
        )
    }

    /**
     * The paint method provides the real magic.  Here we
     * cast the Graphics object to Graphics2D to illustrate
     * that we may use the same old graphics capabilities with
     * Graphics2D that we are used to using with Graphics.
     */
    override fun paint(@NotNull g: Graphics?) {
        super.paint(g)


        if (g == null) {
            return
        }

        //Let's set the Color to blue and then use the Graphics2D
        //object to draw a rectangle, offset from the square.
        //So far, we've not done anything using Graphics2D that
        //we could not also do using Graphics.  (We are actually
        //using Graphics2D methods inherited from Graphics.)
        val g2d = g as Graphics2D

        for (auto in simMap.getAutomatons()) {
            val loc = simMap.getLocation(auto)
            if (loc != null) {
                drawRect(g2d, Color.BLACK, loc)
            }
        }
        println("im here")

    }

    private fun drawRect(g2D: Graphics2D, color: Color, loc: Location) {
        g2D.color = color
        g2D.drawRect(loc.x * horizontalScale, loc.y * horizontalScale, horizontalScale, verticalScale)
    }

}
