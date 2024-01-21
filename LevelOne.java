import java.awt.event.ActionEvent;
import java.awt.*;

// Extends Level
public class LevelOne extends Level {

    // Amount of walls in level
	private int wallCount = 7;

    // Constructor
	public LevelOne() {
		super();
        // Setting walls array to new array with amount of walls specified
		walls = new Wall[wallCount];
        
        // Setting position of the hole
		xhole = 50;
		yhole = 50;
        
        // Setting hitbox of hole to slightly inside the hole so ball has to fully go into it
		hole = new Rectangle(xhole + 9, yhole + 9, 2, 2);

		// Creates the ball
		ball = new Ball(900, 600);
		// CREATES ARRAY OF WALLS (x, y, width, height)
		walls[0] = new Wall(100, 400, 200, 200);
		walls[1] = new Wall(300, 80, 80, 200);
		walls[2] = new Wall(500, 0, 300, 80);
		walls[3] = new Wall(500, 300, 80, 450);
		walls[4] = new Wall(700, 450, 300, 100);
		walls[5] = new Wall(500, 220, 300, 80);
		walls[6] = new BoostWall(650, 140, 20, 20);

	}
}
