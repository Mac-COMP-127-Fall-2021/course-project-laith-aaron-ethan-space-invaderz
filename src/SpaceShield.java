import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class SpaceShield extends Image {
    // public static final double WIDTH = 100;
    // public static final double HEIGHT = 30;
    
    public SpaceShield() {
        super(0, 0, "shield2.png");
        this.setScale(0.3);
    }

    /**
     * updates shield positoin
     * 
     * @param spaceShield shield to update position of
     * @param x x position
     * @param y y position
     */
    public void updatePosition(double x, double y){
        this.setPosition(x, y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }  
}
