import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.*;

// Extending Level
public class LevelTwo extends Level {
  
  // Number of walls in the level
	private int wallCount = 17;

	public LevelTwo() {
		super();
		walls = new Wall[wallCount];


    // Position of hole
		xhole = 950;
		yhole = 20;

    // Position of hole hitbox (small 2 by 2)
		hole = new Rectangle(xhole + 9, yhole + 9, 2, 2);

		// Creates the ball
		ball = new Ball(260, 460);
		// CREATES ARRAY OF WALLS (x, y, width, height)

		PortalWall a = new PortalWall(20, 20, 20, 20, new Color(0, 255, 255));
		PortalWall b = new PortalWall(506, 620, 20, 20, new Color(0, 255, 255));
		a.setLink(b);
		b.setLink(a);
		walls[0] = b;
		walls[1] = a;
		walls[2] = new Wall(0, 100, 200, 80);
		walls[3] = new Wall(277, 0, 80, 200);
		walls[4] = new Wall(100, 336, 80, 224);
		walls[5] = new Wall(180, 336, 300, 80);
		walls[6] = new Wall(380, 416, 100, 276);
		walls[7] = new Wall(480, 100, 80, 380);
		walls[8] = new Wall(670, 0, 100, 300);
		walls[9] = new Wall(480, 480, 300, 100);
		walls[10] = new Wall(862, 150, 150, 400);
		walls[11] = new BoostWall(40, 450, 20, 20);
		walls[12] = new BoostWall(390, 150, 20, 20);
		walls[13] = new BoostWall(590, 150, 20, 20);
		walls[14] = new BoostWall(700, 370, 20, 20);
		walls[15] = new BoostWall(810, 500, 20, 20);
		walls[16] = new BoostWall(830, 150, 20, 20);

	}

}