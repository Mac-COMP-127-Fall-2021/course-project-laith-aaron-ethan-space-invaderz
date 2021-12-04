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

    public void shoot(CanvasWindow canvas, AlienWall alienWall) {
        Bullet bullet = new Bullet(canvas, alienWall, this.getX() + (this.getX()/2), this.getY() + (this.getY()/2));
        bullet.shootDown();
    }
    
}

