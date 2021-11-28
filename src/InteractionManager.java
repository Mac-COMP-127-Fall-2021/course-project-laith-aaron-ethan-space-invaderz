import edu.macalester.graphics.CanvasWindow;

import edu.macalester.graphics.Point;

public class InteractionManager {
    public void alienIntersection(Bullet bullet, Alien alien, CanvasWindow canvas) {
        
        Point bulletPoint = new Point(bullet.getX(), bullet.getY() + bullet.getRadius()+ 1);

        
        if (canvas.getElementAt(bulletPoint) == alien) {
            
        }
    }
}

