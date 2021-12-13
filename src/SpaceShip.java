import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;


public class SpaceShip extends Image {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private static int health = 100;
    
    
    public SpaceShip(CanvasWindow canvas) {
        super(0, 0, "spaceShipImage.png");
        this.setScale(0.15);
        updateCenter(SpaceInvaderz.getCanvasWidth() / 2, SpaceInvaderz.getCanvasHeight() * 0.9);
        canvas.add(this);
    }

    /**
     * updates space ship image position.
     * 
     * @param spaceShipImage space ship.
     * @param x new x value.
     * @param y new y value.
     */
    private void updateCenter(double x, double y) {
        this.setCenter(x, y);
    }

    /**
     * updates spaceShip x position
     * 
     * @param x new x position
     */
    public void updateX(double x) {
        if (getCenterX() > 0 + WIDTH / 2) {
            updateCenter(x, SpaceInvaderz.getCanvasHeight() * 0.9);
        }
    }

    public double getCenterX() {
        return this.getX() + this.getWidth()/2;
    }

    public double getCenterY() {
        return this.getY() + this.getHeight()/2;
    }

    /**
     * Checks if spaceShip is in bounds.
     * 
     * @return true if in bounds, false if not.
     */
    public boolean ifInBounds() {
        if ((getCenterX() + (WIDTH / 2) < SpaceInvaderz.getCanvasWidth()) && getCenterX() - (WIDTH / 2) > 0) {
            return true;
        }
        return false;
    }

    /**
     * returns health points of ship.
     * @return returns health points of ship.
     */
    public static int getHealth() {
        return health;
    }

    /**
     * Damges ship by 20 healthg points.
     */
    public void getDamged() {
        health -= 20;
        HealthMeter.updateHealthMeter();
    }
}
