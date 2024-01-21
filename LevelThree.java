import java.awt.event.ActionEvent;
import java.awt.*;

// Extends Level
public class LevelThree extends Level {

    // Amount of walls in level
	private int wallCount = 30;

    // Constructor
	public LevelThree() {
		super();
        // Setting walls array to new array with amount of walls specified
		walls = new Wall[wallCount];

        // Setting postion of hole
		xhole = 450;
		yhole = 350;

        // Setting hitbox of hole to slightly inside hole
		hole = new Rectangle(xhole + 9, yhole + 9, 2, 2);

		// Creates the ball
		ball = new Ball(600, 400);
		// CREATES ARRAY OF WALLS (x, y, width, height)
		walls[0] = new Wall(200, 150, 220, 50);
		walls[1] = new Wall(300, 0, 50, 150);
		walls[2] = new Wall(100, 100, 100, 100);
		walls[3] = new Wall(0, 300, 150, 50);
		walls[4] = new Wall(100, 350, 50, 150);
		walls[5] = new Wall(220, 320, 60, 130);
		walls[6] = new Wall(350, 200, 70, 200);
		walls[7] = new Wall(350, 400, 150, 50);
		walls[8] = new Wall(500, 0, 50, 700);
		walls[9] = new Wall(550, 300, 100, 50);
		walls[10] = new Wall(700, 100, 70, 100);
		walls[11] = new Wall(650, 100, 50, 250);
		walls[12] = new Wall(550, 450, 350, 50);
		walls[13] = new Wall(720, 580, 60, 120);
		walls[14] = new Wall(850, 0, 50, 450);
        
		// Portal walls
		PortalWall a = new PortalWall(590, 250, 20, 20, new Color(255, 0, 0));
		PortalWall b = new PortalWall(40, 390, 20, 20, new Color(255, 0, 0));
        // Linking portals together so ball teleports to correct one
		a.setLink(b);
		b.setLink(a);
        // Adding portals walls to array
		walls[15] = a;
		walls[16] = b;

        // Creating portal walls
		PortalWall c = new PortalWall(240, 110, 20, 20, new Color(153, 51, 255));
		PortalWall d = new PortalWall(660, 620, 20, 20, new Color(153, 51, 255));
        // Linking portal walls
		c.setLink(d);
		d.setLink(c);
        // Adding portal walls to array
		walls[17] = c;
		walls[18] = d;

        // Creating portal walls
		PortalWall e = new PortalWall(940, 30, 20, 20, new Color(0, 255, 255));
		PortalWall f = new PortalWall(370, 110, 20, 20, new Color(0, 255, 255));
        // Linking portal walls
		e.setLink(f);
		f.setLink(e);
        // Adding portal walls to array
		walls[19] = e;
		walls[20] = f;

        // Initializing and adding boost walls to array
		walls[21] = new BoostWall(40, 140, 20, 20);
		walls[22] = new BoostWall(230, 270, 20, 20);
		walls[23] = new BoostWall(300, 380, 20, 20);
		walls[24] = new BoostWall(170, 620, 20, 20);
		walls[25] = new BoostWall(600, 620, 20, 20);
		walls[26] = new BoostWall(870, 620, 20, 20);
		walls[27] = new BoostWall(940, 480, 20, 20);
		walls[28] = new BoostWall(720, 300, 20, 20);
		walls[29] = new BoostWall(690, 20, 20, 20);

	}

}

