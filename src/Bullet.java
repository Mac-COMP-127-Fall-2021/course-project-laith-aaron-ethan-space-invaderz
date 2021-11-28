import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import java.awt.Color;

public class Bullet extends Ellipse{
    private static final double BULLET_RADIUS = 4;
    private double centerX;
    private double centerY;
    private InteractionManager interactionManager;

    public Bullet(CanvasWindow canvas, AlienWall alienWall) {
        super(SpaceShip.getCenterX(), SpaceShip.getCenterY(), BULLET_RADIUS, BULLET_RADIUS * 7);
        this.centerX = SpaceShip.getCenterX();
        this.centerY = SpaceShip.getCenterY();
        this.setFilled(true);
        this.setStroked(false);
        this.setFillColor(new Color(255, 149, 5));
        canvas.add(this, centerX, centerY);
        interactionManager = new InteractionManager();
        
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
     * updates bullet's Y position
     * 
     * @param y2 new Y position
     */
    public void updateYPosition(double y2){
        this.setY(y2);
    }

    public double getRadius() {
        return BULLET_RADIUS;
    }

    public void checkIntersection(AlienWall alienWall, CanvasWindow canvas) {
        interactionManager.alienIntersection(this, alienWall, canvas);
    }
}
