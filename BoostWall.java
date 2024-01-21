import java.awt.Color;

// Extending wall
public class BoostWall extends Wall {

    // On attribute to determine if used or not
	private boolean on;

    // Constructer setting its position and size
	public BoostWall(int x, int y, int w, int h) {
		super(x, y, w, h);
        // Setting color of the boosts
		setColor(new Color(255, 255, 50));
        // Setting on to true
		on = true;
	}

    @Override
    // Overriding the bounce method
	public void bounce(Ball ball) {
        // If the boost is on, change the velocity vector to 15
		if (on) {
			double speed = Math.sqrt(ball.getXVel() * ball.getXVel() + ball.getYVel() * ball.getYVel());
			ball.setXvel(ball.getXVel() * (15 / speed));
			ball.setYvel(ball.getYVel() * (15 / speed));
            // Setting color to the green of grass
			setColor(new Color(107, 156, 88));
            // Turning wall off
			on = false;
		}
	}
}
