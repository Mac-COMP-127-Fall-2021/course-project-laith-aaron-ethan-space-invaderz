import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;


public class SpaceShip {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    
    private static Image spaceShipImage;

    public SpaceShip(CanvasWindow canvas) {

        spaceShipImage = new Image(0, 0, "spaceShipImage.png");
        spaceShipImage.setScale(0.15);
        updateCenter(spaceShipImage, SpaceInvaderz.getCanvasWidth() / 2, SpaceInvaderz.getCanvasHeight() * 0.9);
        canvas.add(spaceShipImage);
    }

    /**
     * updates space ship image position.
     * 
     * @param spaceShipImage space ship.
     * @param x new x value.
     * @param y new y value.
     */
    private void updateCenter(Image spaceShipImage, double x, double y) {
        spaceShipImage.setCenter(x, y);
    }

    /**
     * updates spaceShip x position
     * 
     * @param x new x position
     */
    public void updateX(double x) {
        if (getCenterX() > 0 + WIDTH / 2) {
            updateCenter(spaceShipImage, x, SpaceInvaderz.getCanvasHeight() * 0.9);
        }
    }


    public static double getCenterX() {
        return spaceShipImage.getCenter().getX();
    }

    public static double getCenterY() {
        return spaceShipImage.getCenter().getY();
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
}
