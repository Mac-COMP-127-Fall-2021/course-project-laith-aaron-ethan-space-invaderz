import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import java.awt.Color;


public class Bullet {
    private static final double BULLET_RADIUS = 4;
    private double centerX;
    private double centerY;
    private Ellipse bullet;

    public Bullet(CanvasWindow canvas) {
        this.centerX = SpaceShip.getCenterX();
        this.centerY = SpaceShip.getCenterY();
        bullet = new Ellipse(SpaceShip.getCenterX(), SpaceShip.getCenterY(), BULLET_RADIUS, BULLET_RADIUS * 7);
        bullet.setFilled(true);
        bullet.setStroked(false);
        bullet.setFillColor(new Color(255, 149, 5));
        canvas.add(bullet, centerX, centerY);
    }

    /**
     * Shoots the bullets from the ship upwards 
     */
    public void shoot(){
        double y2 = centerY - 3;
        centerY = y2;
        updateYPosition(y2);
    }

    /**
     * returns ball's center x position.
     * 
     * @return ball's center x as double.
     */
    public double getXposition() {
        return centerX;
    }

    /**
     * returns ball's center y position.
     * 
     * @return ball's center y as double.
     */
    public double getYposition() {
        return centerY;
    }

    /**
     * updates bullet's Y position
     * 
     * @param y2 new Y position
     */
    public void updateYPosition(double y2){
        bullet.setY(y2);
    }
}
