//Authors: Laith, Ethan, and Aaron
//Class: Class that extends GraphicsGroup, and holds many aliens.
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;

public class AlienWall extends GraphicsGroup {

    private List<Alien> aliens = new ArrayList<Alien>();
    private double xVelocity = 0.5;
    private double yVelocity = 0.2;
    public double yDisplacement = 50;

    public AlienWall(CanvasWindow canvas) {
        super();
        generateAlienWall(); // creates wall of aliens
        canvas.add(this);
    }

    /**
     * Generates The wall of aliens consisting of multiple alien rows.
     */
    private void generateAlienWall() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                createAlienRow(i, j); // creates a row of aliens and adds it to the wall
            }
        }
    }

    /**
     * Creates a row of aliens.
     * @param i
     * @param j
     */
    private void createAlienRow(int i, int j) {
        Alien alien = new Alien();
        aliens.add(alien);
        alien.updatePosition(((alien.getImageWidth() * 0.15) * j) - 200, ((alien.getImageHeight() * 0.15) * i) - 50); // sets alien to a certain position in the row
        aliens.add(alien);
        this.add(alien);
    }

    /**
     * returns aliens list.
     * @return aliens list.
     */
    public List<Alien> getAliens() {
        return aliens;
    }

    /**
     * moves alien wall in the Y plane.
     */
    public void moveY() {
        this.setY(this.getY() + yVelocity); // moves wall by value of yVelocity.
        yDisplacement += yVelocity; // Adds change in alienWall Y distance to Y displacement.
    }

    /**
     * moves alien wall in the x plane
     */
    public void moveX() {
        this.setX(this.getX() + xVelocity);
        if (this.getX() == 80 || this.getX() == -90) {
            this.xVelocity = -1 * xVelocity;
        }
    }

    /**
     * Generates a shot from a random alien
     */
    public void alienShoot() {
        int timePause = getRandomNumber(0, 1000); // returns a random number between 0 and 1000.
        if (timePause <= 20 && timePause >= 0) { // shoots if random number is between 0 and 20.
            int alienInd = getRandomNumber(0, aliens.size()); // chooses random alien.
            aliens.get(alienInd).shoot(getCanvas(), this); // makes the radom alien shoot.
        }
    }

    /**
     * generates random number from a range.
     * 
     * @param min minimum number in range.
     * @param max maximum number in range.
     * @return
     */
    public int getRandomNumber(int min, int max) {
        /* help from
        https://www.baeldung.com/java-generating-random-numbers-in-range
        */
        return (int) ((Math.random() * (max - min)) + min); 
    }


    /**
     * returns Y displacement of the wall since start of the game.
     * @return
     */
    public double getYDisplacement() {
        return yDisplacement;
    }
}

