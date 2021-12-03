import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;

public class AlienWall extends GraphicsGroup {
    
    private List<Alien> aliens = new ArrayList<Alien>();
    private double xVelocity = 0.5;
    private double yVelocity = 0.05;

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
        this.setY(this.getY() + yVelocity);
        if (this.getY() == canvas.getWidth() - 10 || this.getY() == 10){
            xVelocity = -1 * xVelocity;
        }
    }
}

