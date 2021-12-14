import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class InteractionManager {

    public boolean alienIntersection(Bullet bullet, AlienWall alienWall, CanvasWindow canvas) {
        Point bulletTop = new Point(bullet.getX(), bullet.getY() - (bullet.getRadius()+ 1));

        for (Alien alien : alienWall.getAliens()) {
            if (alienWall.getElementAt(bulletTop) == alien) {
                alienWall.remove(alien);
                alienWall.getAliens().remove(alien);
                canvas.remove(bullet);
                return true;
            }
        }
        return false;
    }

    public boolean sheildIntersection(Bullet bullet, SpaceShieldManger shieldManger, CanvasWindow canvas) {
        Point bulletTop = new Point(bullet.getX(), bullet.getY() - (bullet.getRadius() + 1));
        Point bulletBottom = new Point(bullet.getX(), bullet.getY() + (bullet.getRadius() + 1));
        
        for (SpaceShield shield : shieldManger.getShields()) {
             if (canvas.getElementAt(bulletTop) == shield || canvas.getElementAt(bulletBottom) == shield) {
                if (shield.getCondition() == 0) {
                    canvas.remove(shield);
                    canvas.remove(bullet);
                    shieldManger.getShields().remove(shield);
                }
                else {
                    canvas.remove(bullet);
                    shield.damage();
                }
                    return true;
             }
        }
        return false;
    }

    public boolean spaceShipInteraction(Bullet bullet, SpaceShip ship, CanvasWindow canvas) {
            Point bulletBottom = new Point(bullet.getX(), bullet.getY() + bullet.getRadius() + 1);
            if (canvas.getElementAt(bulletBottom) == ship) {
                canvas.remove(bullet);
                ship.getDamged();
                return true;
            }
        return false;
    }

}

