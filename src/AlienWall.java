import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;

public class AlienWall extends GraphicsGroup {

    private List<Alien> aliens = new ArrayList<Alien>();
    private double xVelocity = 0.5;
    private double yVelocity = 0.1;

    public AlienWall(CanvasWindow canvas) {
        super();
        generateAlienWall();
        canvas.add(this);
    }

    private void generateAlienWall() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                createAlienRow(i, j);
            }
        }
    }

    private void createAlienRow(int i, int j) {
        Alien alien = new Alien();
        aliens.add(alien);
        alien.updatePosition(((alien.getImageWidth() * 0.15) * j) - 200, ((alien.getImageHeight() * 0.15) * i) - 50);
        aliens.add(alien);
        this.add(alien);
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void moveY(CanvasWindow canvas) {
        this.setY(this.getY() + yVelocity);
    }

    public void moveX(CanvasWindow canvas) {
        this.setX(this.getX() + xVelocity);
        if (this.getX() == 80 || this.getX() == -90) {
            this.xVelocity = -1 * xVelocity;
        }
    }

    public void alienShoot() {
        int timePause = getRandomNumber(0,1000);
        if (timePause < 20 && timePause > 0){

        int alienInd = getRandomNumber(0, aliens.size());
        aliens.get(alienInd).shoot(getCanvas(), aliens.get(alienInd));
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}

