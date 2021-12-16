//Authors: Laith, Ethan, Aaron.
//Class Description: This class manages the bullets after they intersect with other graphical objects.
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;

public class BulletManger {

    private static ArrayList<Bullet> playerBullets = new ArrayList<Bullet>(); // list of player's bullets
    static ArrayList<Bullet> alienBullets = new ArrayList<Bullet>();

    /**
     * Adds a bullet to canvas
     * @param canvas
     * @param alienWall
     * @param spaceShip
     */
    public static void addShot(CanvasWindow canvas, AlienWall alienWall, SpaceShip spaceShip) {
        playerBullets.add(new Bullet(canvas, spaceShip));
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
        ArrayList<Bullet> bulletsToRemove = new ArrayList<>(); // list of bullets to be removed

        for (Bullet bullet : playerBullets) {
            bullet.shoot();
            if (bullet.checkAlienIntersection(alienWall, canvas)) {
                bulletsToRemove.add(bullet);
            } 
            else if (bullet.checkShieldIntersection(canvas, shieldManger)) {
                bulletsToRemove.add(bullet);
            }
            else if (bullet.checkShipIntersetion(canvas, ship)) {
                bulletsToRemove.add(bullet);
            }
        }
        for (Bullet bullet : bulletsToRemove) {
            playerBullets.remove(bullet);
        }
    }

    /**
     * Checks if alien bullets after intersected anything, and if so, adds them to removed bullets.
     * @param alienWall alien wall to check interaction with.
     * @param canvas canvas on which to check interaction.
     * @param shieldManger manages the interaction between shield and bullet.
     * @param ship player's ship to test interaction with.
     */
    public static void shootAlienBullets(
        AlienWall alienWall,
        CanvasWindow canvas,
        SpaceShieldManger shieldManger,
        SpaceShip ship) {
        ArrayList<Bullet> removedBullets = new ArrayList<>();
        for (Bullet alienBullet : alienBullets) {
            alienBullet.shootDown();

            if (alienBullet.checkShieldIntersection(canvas, shieldManger)) { // tests if there is interaction between shield  and bullet.
                removedBullets.add(alienBullet); // adds bullets to the list of bullets that should be removed.
            }
            if (alienBullet.checkShipIntersetion(canvas, ship)) {  // tests if there is interaction between ship and bullet.
                removedBullets.add(alienBullet); // adds bullets to the list of bullets that should be removed.
            }
        }
        for (Bullet alienBullet : removedBullets) {  // removes bullets that exist in the removedBullets list
            playerBullets.remove(alienBullet);
            alienBullets.remove(alienBullet);
        }
    }

    public static ArrayList<Bullet> getBullets() {
        if (playerBullets.isEmpty()) {
            return null;
        } else {
            return playerBullets;
        }
    }



}
