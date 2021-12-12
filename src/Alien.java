import java.util.Timer;
import java.util.TimerTask;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Alien extends Image {
   

    public Alien() {
        super(0, 0, "alienSpaceShip.jpg");
        this.setScale(0.15);
    }

    public void updatePosition(double x, double y) {
        this.setPosition(x, y);
    }

    public void shoot(CanvasWindow canvas, Alien alien) {
        Bullet bullet = new Bullet(canvas, this, alien.getX()  , alien.getY());
        BulletManger.alienBullets.add(bullet);
        bullet.shootDown();
    }
    
}

