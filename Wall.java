import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Wall {

    // Attributes of wall, size postion and middle of it
    private int height, width, xpos, ypos, midx, midy;
    // Hitbox of wall
    private Rectangle wall;
    // Color of the wall
    private Color color;

    // Constructor
    public Wall(int x, int y, int w, int h) {
        // Setting attributes of wall to the given parameters
        color = new Color(255, 255, 255);
        height = h;
        width = w;
        xpos = x;
        ypos = y;
        // Finding the middle x position and y position of the wall
        midx = xpos + (w / 2);
        midy = ypos + (h / 2);
        // Setting the hitbox of the wall
        wall = new Rectangle(x, y, w, h);
    }

    // Getting the x position of the wall
    public int getXPos() {
        return xpos;
    }

    // Gettin the y position of the wall
    public int getYPos() {
        return ypos;
    }

    // Getting the width of the wall
    public int getWidth() {
        return width;
    }

    // Getting the height of the wall
    public int getHeight() {
        return height;
    }

    // Setting the color of the wall
    public void setColor(Color c) {
        color = c;
    }

    // Getting the mid y value of the wall
    public int getMidY() {
        return midy;
    }

    // Drawing the wall
    public void draw(Graphics2D g) {

        // Setting of the color of the wall
        g.setColor(color);
        // Drawing the wall
        g.fillRect(xpos, ypos, width, height);

    }

    // Checking if the ball intersects with the wall
    public boolean intersects(Rectangle rect) {
        if (wall.intersects(rect)) {
            return true;
        }
        return false;
    }

    // Changes the direction of the ball and moves it out of the wall
    public void bounce(Ball ball) {

        
        double xvel = ball.getXVel();
        double yvel = ball.getYVel();

        // Used to dynamically check where the ball is relative to the wall: vertical and horizontal 
        // interactions are not the same to prioritize horizontal bounces on corners because the maps are longer lengthwise 
        int adjustx = 0;
        int adjusty = 0;
        // If moving to the left, position is put on the right side
        if (xvel <= 0)
            adjustx = 15;

        // If moving down, position is placed on the bottom
        if (yvel > 0)
            adjusty = 15;

      
        double ballypos = ball.getYPos() + adjusty;
        double ballxpos = ball.getXPos() + adjustx;
      
        // If this boolean is true, the program determines that the ball hit either the top of bottom of a wall: ypos is outside of wall vertical and xpos is within horizontal 
        if ((ballypos <= ypos || ballypos >= ypos + height) && ballxpos >= xpos
                && ballxpos <= xpos + width) {
          
            // Vertical velocity flip
            ball.changeYDir();
            // Uses middle positions to determine either top or bottom
            if (ballypos < midy) {
                // moves the ball 1 pixel above the wall
                ball.setYPos(ypos - 16);
            } else {
                // moves the ball 1 pixel below wall
                ball.setYPos(ypos + height + 1);
            }
        } else {
            // Horizontal velocity flip
            ball.changeXDir();
            
            if (ballxpos > midx) {
                // moves the ball 1 pixel to the right of wall
                ball.setXPos(xpos + width + 1);

            } else {
                // moves the ball 1 pixel the left of the wall
                ball.setXPos(xpos - 16);
            }
        }
    }
}