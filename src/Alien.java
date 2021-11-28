import edu.macalester.graphics.Image;

public class Alien extends Image {
   
    public Alien() {
        super(0, 0, "alienSpaceShip.jpg");
        this.setScale(0.15);
    }

    public void updatePosition(double x, double y) {
        this.setPosition(x, y);
    }
}

