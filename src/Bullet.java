import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import java.awt.Color;

public class Bullet extends Ellipse {
    private static final double BULLET_RADIUS = 4;
    private double centerX;
    private double centerY;
    private InteractionManager interactionManager;

    /**
     * Creates the bullets that are shot from the player's spaceship.
     * @param canvas canvas to add bullets to.
     * @param centerX
     * @param centerY
     */
    public Bullet(CanvasWindow canvas) {
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
     * Creates bullet from aliens.
     * 
     * @param canvas
     * @param alien
     * @param centerX
     * @param centerY
     */
    public Bullet(CanvasWindow canvas, Alien alien, double centerX, double centerY) {
        super(centerX, centerY, BULLET_RADIUS, BULLET_RADIUS * 7);
        this.centerX = alien.getX() + (alien.getX() / 2);
        this.centerY = alien.getY() + 200;

        this.setFilled(true);
        this.setStroked(false);
        this.setFillColor(new Color(127, 255, 0));
        canvas.add(this, centerX, centerY);
        interactionManager = new InteractionManager();
    }

    /**
     * Shoots the bullets upwards
     */
    public void shoot() {
        double y2 = centerY - 3;
        centerY = y2;
        updateYPosition(y2);
    }

    /**
     * Shoots the bullets downwards
     */
    public void shootDown() {
        double y2 = centerY + 3;
        centerY = y2;
        updateYPosition(y2);
    }

    /**
     * updates bullet's Y position
     * @param y2 new Y position
     */
    public void updateYPosition(double y2) {
        this.setY(y2);
    }

    /**
     * returns bullet radius.
     * 
     * @return returns bullet radius.
     */
    public double getRadius() {
        return BULLET_RADIUS;
    }

    /**
     * checks for interaction between bullet and aliens.
     * 
     * @param alienWall group of aliens to check interaction with.
     * @param canvas    canvas on which bullet is on.
     * @return boolean: true if bullet and an alien intersect.
     */
    public boolean checkAlienIntersection(AlienWall alienWall, CanvasWindow canvas) {
        return interactionManager.alienIntersection(this, alienWall, canvas);
    }

    /**
     * checks for interaction between bullet and shields.
     * 
     * @param canvas       canvas on which bullet is on.
     * @param shieldManger shields to check interaction with.
     * @return boolean: true if bullet and shield intersect.
     */
    public boolean checkShieldIntersection(CanvasWindow canvas, SpaceShieldManger shieldManger) {
        return interactionManager.sheildIntersection(this, shieldManger, canvas);
    }
}
