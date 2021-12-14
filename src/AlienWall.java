import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;

public class AlienWall extends GraphicsGroup {

    private List<Alien> aliens = new ArrayList<Alien>();
    private double xVelocity = 0.5;
    private double yVelocity = 0.4;

    public AlienWall(CanvasWindow canvas) {
        super();
        generateAlienWall();
        canvas.add(this);
    }

    /**
     * Generates The wall of aliens consisting of multiple alien rows.
     */
    private void generateAlienWall() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                createAlienRow(i, j);
            }
        }
    }

    /**
     * Creates a row of aliens.
     * 
     * @param i
     * @param j
     */
    private void createAlienRow(int i, int j) {
        Alien alien = new Alien();
        aliens.add(alien);
        alien.updatePosition(((alien.getImageWidth() * 0.15) * j) - 200, ((alien.getImageHeight() * 0.15) * i) - 50);
        aliens.add(alien);
        this.add(alien);
    }

    /**
     * returns aliens list.
     * 
     * @return aliens list.
     */
    public List<Alien> getAliens() {
        return aliens;
    }

    /**
     * moves alien wall in the Y plane.
     */
    public void moveY() {
        this.setY(this.getY() + yVelocity);
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
        
        int timePause = getRandomNumber(0, 1000); // Used as timepause by making it animate the random function and not
                                                // executing always.
        if (timePause < 20 && timePause > 0) {

            int alienInd = getRandomNumber(0, aliens.size());
            aliens.get(alienInd).shoot(getCanvas());
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
        return (int) ((Math.random() * (max - min)) + min);
    }
}

