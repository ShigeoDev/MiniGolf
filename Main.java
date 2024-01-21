public class Main {

    public static void main(String[] args) {
        // Creating a Level One Object
        Level level = new LevelOne();

        // Creating a course object with the level as the parameter
        Course course = new Course(level);

        // Waiting for level to be complete before moving on
        while (!level.complete()) {
            // Having slight delay so Java Swing can update, without it it will not work
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Creating a level two object
        Level level2 = new LevelTwo();

        // Switching the level from level one to level two
        course.switchLevel(level2);


        // Waiting for level to be complete before moving on
        while (!level2.complete()) {
            // Having slight delay so Java Swing can update, without it it will not work
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Creating a level three object
        Level level3 = new LevelThree();

        // Switching the level from level two to level three
        course.switchLevel(level3);

        // Waiting for level to be complete before moving on
        while (!level3.complete()) {
            // Having slight delay so Java Swing can update, without it it will not work
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Switching to end screen
        course.endScreen();

    }
}
