
// Authors: Laith, Ethan, Aaron.
// Class Description: Class that creates each indvidual alien image, with alien methods like shoot.
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Alien extends Image {

    public Alien() {
        super(0, 0, "alienSpaceShip.jpg");
        this.setScale(0.15); // changes image size
    }

    /**
     * Updates alien position.
     * 
     * @param x new X position.
     * @param y new Y position.
     */
    public void updatePosition(double x, double y) {
        this.setPosition(x, y);
    }

    /**
     * Makes alien shoot a bullet downwards towawrds the space ship.
     * 
     * @param canvas canvas to add bullet to.
     * @param alien  alien to shoot the bullet.
     */
    public void shoot(CanvasWindow canvas, AlienWall alienWall) {
        Bullet bullet = new Bullet(canvas, this, this.getCenter().getX() + alienWall.getX(), this.getCenter().getY() + alienWall.getY(), alienWall);
        BulletManger.alienBullets.add(bullet);
        bullet.shootDown();
    }

    public double getXCenter() {
        return this.getX() + this.getWidth() / 2;
    }

    public double getYCenter() {
        return this.getY() + this.getHeight() / 2;
    }

}

