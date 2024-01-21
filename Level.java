import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

// Extending JPanel and implementing action lister to listen for timer
public class Level extends JPanel implements ActionListener {

    // Protected attributs to pass down to children

    // Timer to constantly update screen
    protected Timer timer;
    // Delay of Time
    protected int delay = 10;
    
    // Boolean if level is complete
    protected boolean levelComplete = false;

    // Ball object attribute
    protected Ball ball;
    // Hitbox of hole
    protected Rectangle hole;
    // Wall array to store walls
    protected Wall[] walls;

    // UI attribute
    protected UI UI;

    // Position of the hole
    protected int xhole;
    protected int yhole;

    // Constructor of the level
    public Level() {
        // Initializing timer with a delay and setting this level as the listener for it
        timer = new Timer(delay, this);
        // Setting size of the panel
        setSize(new Dimension(1100, 700));

    }

    // Setting the user interface for the level
    public void setUserInterface(UI ui) {
        UI = ui;
        // Starting the timer when interface is set
        timer.start();
    }

    // Removing the user interface from a level
    public void removeUserInterface() {
        // Stopping the timer
        timer.stop();
        // Setting UI to null
        UI = null;
    }

    // Getter method to get whether level is complete or not
    public boolean complete() {
        return levelComplete;
    }

    // Getter to get strokes for a level
    public int getScore() {
        return UI.getStrokes();
    }

    // Painting the panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background of the Level created by setting color and filling
        g.setColor(new Color(107, 156, 88));
        g.fillRect(0, 0, 1100, 700);

        // Create hole
        g.setColor(new Color(10, 10, 10));
        g.fillOval(xhole, yhole, 20, 20);

        // Drawing the walls
        for (Wall wall : walls) {
            wall.draw((Graphics2D) g);
        }
        // Ball created by setting color and filling oval
        if (!levelComplete) {
            ball.draw((Graphics2D) g);
        }

        // Create line of shot while ball is not moving
        if (UI != null) {
            if (!UI.isMoving() && !levelComplete) {
                ball.drawLine((Graphics2D) g);
            }

        }

    }

    @Override
    // Getting action event from timer
    public void actionPerformed(ActionEvent e) {

        // Checking if the ball intersects the hole
        if (ball.getRectangle().intersects(hole)) {
            // If it does, set level complete to true
            levelComplete = true;
            // Set the ball as not moving in UI
            UI.setMoving(false);
        }
        // Checking every wall in the array if it is intersecting with the ball
        for (Wall wall : walls) {
            if (wall.intersects(ball.getRectangle())) {
                // If wall intersects bounce the ball
                wall.bounce(ball);
            }
        }

        // If the ball is not moving
        if (!UI.isMoving()) {
            // Calculate the velocity of the ball using the power and angle the user specified
            ball.calculateVelocity(UI.getPower(), UI.getAngle());
        }
        // If ball is moving
        if (UI.isMoving()) {
            // Move the ball
            ball.move();
        }

        // Change the direction of the line
        ball.changeLine();

        // If the ball's velocity vector has a magnitude of zero, set moving to false
        if (ball.getXVel() == 0 && ball.getYVel() == 0) {
            UI.setMoving(false);
        }
        // Repainting panel
        repaint();
    }
}
