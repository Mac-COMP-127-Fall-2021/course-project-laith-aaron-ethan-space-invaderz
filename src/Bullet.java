
// Authors: Laith, Ethan, Aaron.
// Class Description: Class respresenting a bullet, which extends ellipse.
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import java.awt.Color;

public class Bullet extends Ellipse {
    private static final double BULLET_RADIUS = 4;
    private double centerX;
    private double centerY;
    private double yVelocity = 1;
    private InteractionManager interactionManager;

    /**
     * Creates the bullets that are shot from the player's spaceship.
     * 
     * @param canvas  canvas to add bullets to.
     * @param centerX
     * @param centerY
     */
    public Bullet(CanvasWindow canvas, SpaceShip spaceShip) {
        super(spaceShip.getCenterX(), spaceShip.getCenterY(), BULLET_RADIUS, BULLET_RADIUS * 7);
        this.centerX = spaceShip.getCenterX() - 2;
        this.centerY = spaceShip.getCenterY() - spaceShip.getHeight() / 8 + 1;

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
    public Bullet(CanvasWindow canvas, Alien alien, double centerX, double centerY, AlienWall alienWall) {
        super(centerX, centerY, BULLET_RADIUS, BULLET_RADIUS * 7);
        this.centerX = alien.getX();
        this.centerY = alien.getY() + alienWall.getYDisplacement() * 1.9;

        this.setFilled(true);
        this.setStroked(false);
        this.setFillColor(Color.GREEN);
        canvas.add(this, centerX, centerY);
        interactionManager = new InteractionManager();
    }

    /**
     * Shoots the bullets upwards towards alien wall.
     */
    public void shoot() {
        double y2 = centerY - yVelocity;
        centerY = y2;
        updateYPosition(y2);
    }

    /**
     * Shoots the bullets downwards
     */
    public void shootDown() {
        double y2 = centerY + yVelocity;
        centerY = y2;
        updateYPosition(y2);
    }

    /**
     * updates bullet's Y position
     * 
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
     * Returns speed at which wall moves towards player's space ship.
     * 
     * @return y Velocity of the wall.
     */
    public double getYVelocity() {
        return yVelocity;
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

    /**
     * checks for interaction between bullet and player's spaceship.
     * 
     * @param canvas canvas on which to test interaction.
     * @param ship   player's ship.
     * @return boolean: true if bullet and space ship intersect.
     */
    public boolean checkShipIntersetion(CanvasWindow canvas, SpaceShip ship) {
        return interactionManager.spaceShipInteraction(this, ship, canvas);
    }
}
