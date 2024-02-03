import java.awt.Color;

// Extending wall class
public class PortalWall extends Wall {

    // Attribute if wall is on or off
    private boolean on;
    // Other portal that it is linked to
    private PortalWall link;

    // Constructor
    public PortalWall(int x, int y, int w, int h) {
        super(x, y, w, h);
        // Setting color of the wall
        setColor(new Color(153, 0, 153));
        // Turning the wall on
        on = true;
    }

    // Overloaded constructer
    public PortalWall(int x, int y, int w, int h, Color c) {
        super(x, y, w, h);
        // Setting color of the wall
        setColor(c);
        // Turning the wall on
        on = true;
    }

    // Method to link the portals
    public void setLink(PortalWall p) {
        link = p;
    }

    // Turning off the portal
    public void turnOff() {
        on = false;
        // Setting the color to the grass color
        setColor(new Color(107, 156, 88));
    }

    // Overriding bounce method from wall
    public void bounce(Ball ball) {
        // If the wall is on
        if (on) {
            // Move the ball to the other portal
            ball.setXPos(link.getXPos());
            ball.setYPos(link.getYPos());
            // Set the color of the portal to green
            setColor(new Color(107, 156, 88));
            // Turn of the linked portal
            link.turnOff();
            // Turn off this portal 
            on = false;
        }
    }
}
