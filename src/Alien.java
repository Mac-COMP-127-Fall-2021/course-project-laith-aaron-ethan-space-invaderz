import java.awt.*;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;


public class Alien {
    private static Image alienSpaceShip;

    /**
     * Creates an individual brick and sets color as shown in the coordinates above
     */
    public Alien() {
        alienSpaceShip = new Image(0, 0, "alienSpaceShip.jpg");
        alienSpaceShip.setScale(0.15);
    }

    public static double getImageWidth(){
        return alienSpaceShip.getImageWidth();
    }

    public static double getImageHeight(){
        return alienSpaceShip.getImageHeight();
    }

    public static Image getAlienImage(){
        return alienSpaceShip;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(alienSpaceShip);
    }

    public void updatePosition(double x, double y) {
        alienSpaceShip.setPosition(x, y);
    }
}

