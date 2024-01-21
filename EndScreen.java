import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;

// Extending JPanel
public class EndScreen extends JPanel {
    // Strokes attribute to count total strokes
	private int strokes;
    // ArrayList to store stroke counts from each level
	private ArrayList<Integer> arr;

    // Constructor
	public EndScreen() {
        // Setting strokes to 0
		strokes = 0;
        // Initializing arraylist
		arr = new ArrayList<Integer>();
	}

    // Method to add score to arraylist and to total stroke count
	public void addScore(int score) {
        // Adding strokes to arraylist
		arr.add(score);
        // Adding strokes to total score
		strokes += score;
	}

    // Painting the end screen
	public void paintComponent(Graphics g) {

        // Creating a green background
		g.setColor(new Color(107, 156, 88));
		g.fillRect(0, 0, 1200, 700);

        // Setting color to white
		g.setColor(Color.WHITE);
		g.setFont(new Font("", Font.PLAIN, 40));

        // Drawing the text on the end screen
		g.drawString("Total Strokes: " + strokes, 440, 200);
		g.drawString("Hole 1: " + arr.get(0), 500, 300);
		g.drawString("Hole 2: " + arr.get(1), 500, 340);
		g.drawString("Hole 3: " + arr.get(2), 500, 380);

	}

}
