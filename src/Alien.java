import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;


public class Alien extends Image {
   
    /**
     * Creates an individual brick and sets color as shown in the coordinates above
     */
    public Alien() {
        super(0, 0, "alienSpaceShip.jpg");
        this.setScale(0.15);
    }

    // public void addToCanvas(CanvasWindow canvas) {
    //     canvas.add(this);
    // }

    public void updatePosition(double x, double y) {
        this.setPosition(x, y);
    }
}

