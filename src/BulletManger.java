import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;

public class BulletManger {

    static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    static ArrayList<Bullet> alienBullets = new ArrayList<Bullet>();


    public static void addShot(CanvasWindow canvas, AlienWall alienWall) {
        bullets.add(new Bullet(canvas));
    }

    public static void shootBullets(
        AlienWall alienWall,
        InteractionManager interactionManager,
        CanvasWindow canvas,
        SpaceShieldManger shieldManger) {
        ArrayList<Bullet> removedBullets = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.shoot();
            if (bullet.checkAlienIntersection(alienWall, canvas)) {
                removedBullets.add(bullet);
            } else if (bullet.checkShieldIntersection(canvas, shieldManger)) {
                System.out.println("yay");
                removedBullets.add(bullet);
            }
        }


        for (Bullet bullet : removedBullets) {
            bullets.remove(bullet);
        }
    }


    public static void shootAlienBullets(
        AlienWall alienWall,
        InteractionManager interactionManager,
        CanvasWindow canvas,
        SpaceShieldManger shieldManger) {
        ArrayList<Bullet> removedBullets = new ArrayList<>();
        for (Bullet alienBullet : alienBullets) {
            alienBullet.shootDown();

            if (alienBullet.checkShieldIntersection(canvas, shieldManger)) {
                System.out.println("yay");
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
