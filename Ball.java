import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball {

    // Creating atttributes of a ball
    private double ballxpos;
    private double ballypos;
    private double ballxvel;
    private double ballyvel;

    // Variables for creating the line from the ball
    private int linex;
    private int liney;

    // Creating a rectangle around ball to find collisions
    private Rectangle ball;

    // Creating a ball with a x and y position.
    public Ball(int x, int y) {
        ballxpos = x;
        ballypos = y;
        linex = x;
        liney = y;
        ballxvel = 0;
        ballyvel = 0;

    }

    // Calculating the velocity of the ball based on information from UI
    public void calculateVelocity(int power, int angle) {
        // Setting x vel to cosine of velocity vector
        ballxvel = ((Math.cos(Math.toRadians(angle))) * power);
        
        // Making the x velocity smaller so it doesn't go too fast
        ballxvel *= 0.2;

        // Setting y vel to sin of the velocity vector
        ballyvel = ((Math.sin(Math.toRadians(angle))) * power);

        // Making the y velocity smaller so doesn't go too fast
        ballyvel *= 0.2;
    }

    // Method to move the ball
    public void move() {

        // Adding xvel and yvel to position to move it
        ballxpos += ballxvel;
        ballypos -= ballyvel;

        // Checking if ball is within bounds
        if (ballxpos < 0) {
            // Setting position to where wall ends
            ballxpos = 0;
            // Switching x direction of ball
            ballxvel *= -1;
        }
        if (ballxpos > 997) {
            // Setting position to where wall ends
            ballxpos = 997;
            // Switching ball x direction
            ballxvel *= -1;
        }
        if (ballypos > 657) {
            // Setting postion to where wall ends
            ballypos = 657;
            // Switching ball y direction
            ballyvel *= -1;
        }
        if (ballypos < 0) {
            // Setting position to where wall ends
            ballypos = 0;
            // Switching ball y direction
            ballyvel *= -1;
        }
        // Decreasing both the x velocity vector and y velocity vector to decrease the velocity vector while conserving angle
        ballxvel *= 0.98;
        ballyvel *= 0.98;

        // If the velocity is close to zero it sets it to zero because it wouldn't reach zero without it
        if (Math.abs(ballxvel) < 0.1) {
            ballxvel = 0;
        }
        if (Math.abs(ballyvel) < 0.1) {
            ballyvel = 0;
        }
    }

    // Setter to set xvel
    public void setXvel(double x) {
        ballxvel = x;
    }

    // Setter to set y vel
    public void setYvel(double y) {
        ballyvel = y;
    }

    // Getter to get x vel
    public double getXVel() {
        return ballxvel;
    }

    // Getter to get y vel
    public double getYVel() {
        return ballyvel;
    }

    // Getter to get x pos
    public double getXPos() {
        return ballxpos;
    }

    // Getter to get y pos
    public double getYPos() {
        return ballypos;
    }

    // Setter to set y pos
    public void setYPos(int y) {
        ballypos = y;
    }

    // Setter to set x pos
    public void setXPos(int x) {
        ballxpos = x;
    }

    // Changing x dir of ball
    public void changeXDir() {
        ballxvel *= -1;
    }

    // Change y dir of ball
    public void changeYDir() {
        ballyvel *= -1;
    }

    // Getting the hitbox of the ball
    public Rectangle getRectangle() {
        // Recalculating where the rectangle is
        ball = new Rectangle((int) ballxpos, (int) ballypos, 15, 15);
        return ball;
    }

    // Change the line of the ball
    public void changeLine() {
        // Setting the x position of the line to the position of the ball + the x velocity vector multipled by 10
        linex = (int) ballxpos + (int) (10 * ballxvel);
        // Setting the y position of the line to the position of the ball + the y velocity vector multipled by 10
        liney = (int) ballypos - (int) (10 * ballyvel);
    }

    // Drawing the ball
    public void draw(Graphics2D g) {
        // Setting color to white
        g.setColor(Color.WHITE);

        // Making a circle at position of the ball with diameter of 15 
        g.fillOval((int) Math.round(ballxpos), (int) Math.round(ballypos), 15, 15);
    }

    // Draw the line of the ball
    public void drawLine(Graphics2D g) {
        // Setting color to white
        g.setColor(Color.WHITE);

        //  Drawing the line form the ball pos to the line postion
        g.drawLine((int) (Math.round(ballxpos + 8)), (int) (Math.round(ballypos + 8)), linex + 8, liney + 8);
    }
}
