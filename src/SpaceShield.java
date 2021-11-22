
import edu.macalester.graphics.Rectangle;
import java.awt.Color;


public class SpaceShield {
    public static final double WIDTH = 100;
    public static final double HEIGHT = 30;

    public SpaceShield() {
        Rectangle shield = new Rectangle(0,0,WIDTH, HEIGHT);
        shield.setFillColor(new Color(0, 128, 128));
    }

    /**
     * updates shield positoin
     * 
     * @param shield shield to update position of
     * @param x x position
     * @param y y position
     */
    public void updatePosition(Rectangle shield, double x, double y){
        shield.setCenter(x , y);
    }
    
}
