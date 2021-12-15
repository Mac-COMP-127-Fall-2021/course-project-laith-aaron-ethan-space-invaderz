//Authors: Ethan, Laith, Aaron.
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class InteractionManager {
    /**
     * checks to see if a bullet has intersected with one of the aliens.
     * @param bullet
     * @param alienWall
     * @param canvas
     * @return
     */
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
    /**
     * checks to see if a bullet has intersected with shield, if it still has health take one away.
     * @param bullet
     * @param shieldManger
     * @param canvas
     * @return
     */
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
    /**
     * check to see if bullet has intersected with the spaceship.
     * @param bullet
     * @param ship
     * @param canvas
     * @return
     */
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

