import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

// Extending Jpanel and implementing Actionlistener and Changelistener
public class UI extends JPanel implements ActionListener, ChangeListener {

    // Creating a power slider, angle slider, shoot button, and labels for each
	JSlider power = new JSlider(0, 0, 50, 25);
	JSlider angle = new JSlider(0, 0, 360, 180);
	JButton shoot = new JButton("Click to Shoot");
	JLabel p = new JLabel("Power");
	JLabel a = new JLabel("Angle");
	JLabel strokecount = new JLabel("Strokes: 0");

    // Variables to store data from sliders
	private int degree;
	private int strength;

    // Amount of strokes to be displayed
	private int strokes = 0;

    // Boolean for if ball is moving
	boolean moving = false;

    // Constructor
	public UI() {
        // Setting paint track, ticks, and labels as well as spacing and the name of the slider
		power.setPaintTrack(true);
		power.setPaintTicks(true);
		power.setPaintLabels(true);
		power.setMajorTickSpacing(10);
		power.setMinorTickSpacing(1);
		power.setName("Power");

        // Setting paint track, ticks, and labels as well as spacing and the name of the slider
		angle.setPaintTrack(true);
		angle.setPaintTicks(true);
		angle.setPaintLabels(true);
		angle.setMajorTickSpacing(90);
		angle.setMinorTickSpacing(30);
		angle.setName("Angle");

        // Setting the allignment of the labels
		p.setHorizontalAlignment(JLabel.CENTER);
		p.setVerticalAlignment(JLabel.TOP);
		a.setHorizontalAlignment(JLabel.CENTER);
		a.setVerticalAlignment(JLabel.TOP);
		strokecount.setVerticalAlignment(JLabel.BOTTOM);
		strokecount.setHorizontalAlignment(JLabel.CENTER);

        // Setting the layout of the JPanel 
		setLayout(new GridLayout(6, 0));

        // Setting the size of the JPanel
		setMaximumSize(new Dimension(150, 1080));

        // Setting action listener for the button
		shoot.addActionListener(this);
        // Adding change listeners to detect when they are changed
		shoot.addChangeListener(this);
		power.addChangeListener(this);
		angle.addChangeListener(this);

        // Adding all the elements above to the JPanel
		add(power);
		add(p);
		add(angle);
		add(a);
		add(strokecount);
		add(shoot);
	}

    // If Button is pressed
	public void actionPerformed(ActionEvent e) {
    // method only works when ball is not moving
		if (moving == false) {
        // Adds one to strokes
			strokes++;
      
        // Get the value of the sliders
			strength = power.getValue();
			degree = angle.getValue();
      
        // Set moving to true
			moving = true;

		}
	}

    // Get the strokes
	public int getStrokes() {
		return strokes;
	}

    // Reset the strokes
	public void resetStrokes() {
		strokes = 0;
	}

    // Get the power of the slider
	public int getPower() {
		strength = power.getValue();
		return strength;
	}

    // Get the angle of the slider
	public int getAngle() {
		degree = angle.getValue();
		return degree;
	}

    // Getter to get if ball is moving
	public boolean isMoving() {
		return moving;
	}

    // Set if the ball is moving
	public void setMoving(boolean set) {
		moving = set;
	}

    // Method is called every time a slider or button has changed
	public void stateChanged(ChangeEvent e) {
        // Setting text of sliders to value of it
		p.setText("Power: " + power.getValue());
		a.setText("Angle: " + angle.getValue());
        // Setting stroke count label to amount of strokes
		strokecount.setText("Strokes: " + strokes);
	}
}
