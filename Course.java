import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

// Extending JFrame
public class Course extends JFrame {
    // Level attribute to show level
    Level level;
    // JPanel container to store both UI and Level
    JPanel container = new JPanel();
    // Creating UI
    UI UI = new UI();
    // Creating an endscreen
    EndScreen endscreen = new EndScreen();

    // Constructor with level parameter
    public Course(Level l) {
        // Making window called Mini Golf
        super("Mini Golf");

        // Setting basic stuff for JFrame (location, resizable, close operation, visibility, size)    
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1200, 700);

        // Setting the layout of the container to make it fit both the UI and Level
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        // Setting level to the parameter level
        level = l;
        // Setting the user interface of the level
        level.setUserInterface(UI);

        // Add the level and UI to container, and adding container to the JFrame
        container.add(level);
        container.add(UI);
        add(container);
    }

    // Method to switch level
    public void switchLevel(Level l) {
        // Adding the score to the end screen
        endscreen.addScore(level.getScore());
        // Reset strokes on the UI
        UI.resetStrokes();

        // Removing all components in the container (level and UI)
        container.removeAll();

        // If there is a level object, remove the user interface
        if (level != null) {
            level.removeUserInterface();
        }
        // Setting level to the new level from the parameter
        level = l;
        // Setting the user interface of the level
        level.setUserInterface(UI);

        // Adding level and UI to container
        container.add(level);
        container.add(UI);

        // Repainting container to update the screen
        container.repaint();
        // Revalidating the JFrame
        container.revalidate();
    }

    // Switching to End screen
    public void endScreen() {
        // Adding score of last level to end screen
        endscreen.addScore(level.getScore());

        // Removing all components of container
        container.removeAll();
        
        // Adding end screen to the container, and repainting and revalidating it
        container.add(endscreen);
        container.repaint();
        container.revalidate();
    }
}
