
// Authors: Ethan, Laith, Aaron.
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class InteractionManager {

    /**
     * checks to see if a bullet has intersected with one of the aliens, and removes aliens that are
     * getting shot.
     * 
     * @param bullet    bullet to check interaction with.
     * @param alienWall alienwall to check interaction with.
     * @param canvas    canvas on which to check interaction.
     * @return boolean: true if there is interaction. false if there is not
     */
    public boolean alienIntersection(Bullet bullet, AlienWall alienWall, CanvasWindow canvas) {
        Point bulletTop = new Point(bullet.getX(), bullet.getY() - (bullet.getRadius() + 1));  // gets the position at
                                                                                               // the top of bullet

        for (Alien alien : alienWall.getAliens()) {
            if (alienWall.getElementAt(bulletTop) == alien) {  // checks for interaction between bullet and alien
                alienWall.remove(alien); // removes alien if it gets shot
                alienWall.getAliens().remove(alien);
                canvas.remove(bullet); // removes bullet that shot the alien from canvas
                return true;
            }
        }
        return false;
    }

    /**
     * checks to see if a bullet has intersected with shield, if it still has health take one away.
     * 
     * @param bullet       bullet to check interaction with.
     * @param shieldManger shield manger that controls shield behavior.
     * @param canvas       canvas on which to check interaction.
     * @return boolean: true if there is interaction. false if there is not
     */
    public boolean sheildIntersection(Bullet bullet, SpaceShieldManger shieldManger, CanvasWindow canvas) {
        Point bulletTop = new Point(bullet.getX(), bullet.getY() - (bullet.getRadius() + 1)); // returns bullet's top
                                                                                              // position
        Point bulletBottom = new Point(bullet.getX(), bullet.getY() + (bullet.getRadius() + 1)); // returns bullet's
                                                                                                 // bottom position

        for (SpaceShield shield : shieldManger.getShields()) {
            if (canvas.getElementAt(bulletTop) == shield || canvas.getElementAt(bulletBottom) == shield) {
                if (BulletManger.alienBullets.contains(bullet)) {
                    if (shield.getHealth() - 1  == 0) {
                        canvas.remove(shield);
                        canvas.remove(bullet);
                        shieldManger.getShields().remove(shield);
                    } else {
                        canvas.remove(bullet);
                        shield.getDamged(); // reduces shield health by 1
                    }
                }
                else {
                    canvas.remove(bullet);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * check to see if bullet has intersected with the spaceship.
     * 
     * @param bullet bullet to check interaction with.
     * @param ship   ship to check interaction with.
     * @param canvas canvas on which to check interaction.
     * @return boolean: true if there is interaction. false if there is not
     */
    public boolean spaceShipInteraction(Bullet bullet, SpaceShip ship, CanvasWindow canvas) {
        Point bulletBottom = new Point(bullet.getX(), bullet.getY() + bullet.getRadius() + 1); // gets position at
                                                                                               // bottom of bullet.
        if (canvas.getElementAt(bulletBottom) == ship) { // checks for interaction between bullet and ship
            canvas.remove(bullet); // removes bullet from canvas
            ship.damgeShield();  // lowers ship health
            return true;
        }
        return false;
    }

}

