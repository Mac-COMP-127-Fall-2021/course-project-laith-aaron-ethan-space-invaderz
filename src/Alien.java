import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Alien extends Image {

    public Alien() {
        super(0, 0, "alienSpaceShip.jpg");
        this.setScale(0.15);
    }

    /**
     * Updates alien position.
     * @param x new X position.
     * @param y new Y position.
     */
    public void updatePosition(double x, double y) {
        this.setPosition(x, y);
    }

    /**
     * Makes alien shoot a bullet downwards towawrds the space ship.
     * @param canvas canvas to add bullet to.
     * @param alien alien to shoot the bullet.
     */
    public void shoot(CanvasWindow canvas, Alien alien) {
        Bullet bullet = new Bullet(canvas, this, alien.getX(), alien.getY());
        BulletManger.alienBullets.add(bullet);
        bullet.shootDown();
    }
}

