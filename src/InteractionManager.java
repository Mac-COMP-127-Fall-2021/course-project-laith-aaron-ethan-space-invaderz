
import edu.macalester.graphics.Point;

public class InteractionManager {
    public void alienIntersection(Bullet bullet, AlienWall alienWall) {
        
        Point bulletPoint = new Point(bullet.getX(), bullet.getY() + bullet.getRadius()+ 1);

        for (Alien alien : alienWall.getAliens()) {
            if (alienWall.getElementAt(bulletPoint) == alien) {
                alienWall.remove(alien);
            }
        }
    }
}

