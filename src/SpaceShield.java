import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class SpaceShield extends Image {
    // public static final double WIDTH = 100;
    // public static final double HEIGHT = 30;
    private int condition = 3;
    
    public SpaceShield() {
        super(0, 0, "shield2.png");
        this.setScale(0.3);
    }

    public int getCondition() {
        return condition;
    }

    public void damage() {
        condition -= 1;
    }

}
