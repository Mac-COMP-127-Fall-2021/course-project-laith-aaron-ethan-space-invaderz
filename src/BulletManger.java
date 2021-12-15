//Authors: Laith, Ethan, Aaron.
//Class Description: This class manages the bullets after they intersect with other graphical objects.
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;

public class BulletManger {

    private static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    static ArrayList<Bullet> alienBullets = new ArrayList<Bullet>();

    public static void addShot(CanvasWindow canvas, AlienWall alienWall, SpaceShip spaceShip) {
        bullets.add(new Bullet(canvas, spaceShip));
    }
    /**
     * checks for bullet intersection and if there is, adds bullets to removed bullets.
     * @param alienWall
     * @param interactionManager
     * @param canvas
     * @param shieldManger
     * @param ship
     */
    public static void shootBullets(
        AlienWall alienWall,
        InteractionManager interactionManager,
        CanvasWindow canvas,
        SpaceShieldManger shieldManger,
        SpaceShip ship) {
        ArrayList<Bullet> removedBullets = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.shoot();
            if (bullet.checkAlienIntersection(alienWall, canvas)) {
                removedBullets.add(bullet);
            } 
            else if (bullet.checkShieldIntersection(canvas, shieldManger)) {
                removedBullets.add(bullet);
            }
            else if (bullet.checkShipIntersetion(canvas, ship)) {
                removedBullets.add(bullet);
            }
        }
        for (Bullet bullet : removedBullets) {
            bullets.remove(bullet);
        }
    }

    /**
     * Checks if alien bullets after intersected anything, and if so, adds them to removed bullets.
     * @param alienWall
     * @param interactionManager
     * @param canvas
     * @param shieldManger
     * @param ship
     */
    public static void shootAlienBullets(
        AlienWall alienWall,
        InteractionManager interactionManager,
        CanvasWindow canvas,
        SpaceShieldManger shieldManger,
        SpaceShip ship) {
        ArrayList<Bullet> removedBullets = new ArrayList<>();
        for (Bullet alienBullet : alienBullets) {
            alienBullet.shootDown();

            if (alienBullet.checkShieldIntersection(canvas, shieldManger)) {
                removedBullets.add(alienBullet);
            }
            if (alienBullet.checkShipIntersetion(canvas, ship)) {
                removedBullets.add(alienBullet);
            }
        }
        for (Bullet alienBullet : removedBullets) {
            bullets.remove(alienBullet);
            alienBullets.remove(alienBullet);
        }
    }

    public static ArrayList<Bullet> getBullets() {
        if (bullets.isEmpty()) {
            return null;
        } else {
            return bullets;
        }
    }



}
