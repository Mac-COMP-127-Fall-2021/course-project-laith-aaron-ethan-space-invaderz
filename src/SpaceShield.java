import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class SpaceShield {
    // public static final double WIDTH = 100;
    // public static final double HEIGHT = 30;
    public static Image spaceShield;

    public SpaceShield() {
        spaceShield = new Image(0, 0, "shield2.png");
        spaceShield.setScale(0.3);
    }

    /**
     * updates shield positoin
     * 
     * @param spaceShield shield to update position of
     * @param x x position
     * @param y y position
     */
    public void updatePosition(double x, double y){
        spaceShield.setPosition(x, y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(spaceShield);
    }  
}
