
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class InteractionManager {

    public boolean alienIntersection(Bullet bullet, AlienWall alienWall, CanvasWindow canvas) {
        Point bulletPoint = new Point(bullet.getX(), bullet.getY() + bullet.getRadius()+ 1);

        for (Alien alien : alienWall.getAliens()) {
            if (alienWall.getElementAt(bulletPoint) == alien) {
                alienWall.remove(alien);
                alienWall.getAliens().remove(alien);
                canvas.remove(bullet);
                return true;
            }
        }
        return false;
    }

    public boolean sheildIntersection(Bullet bullet, SpaceShieldManger shieldManger, CanvasWindow canvas) {
        
        Point bulletPoint = new Point(bullet.getX(), bullet.getY() + bullet.getRadius()+ 1);

        for (SpaceShield shield : shieldManger.getShields()){
             if (canvas.getElementAt(bulletPoint) == shield) {
                canvas.remove(shield);
                shieldManger.getShields().remove(shield);
                canvas.remove(bullet);
                return true;
             }
        }
        return false;
    }
}

