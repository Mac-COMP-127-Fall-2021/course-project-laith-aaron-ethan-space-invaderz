
import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.*;

public class SpaceShieldManger {
    // private GraphicsGroup shieldGroup;
    private static List<SpaceShield> shields = new ArrayList<SpaceShield>();
    private static CanvasWindow canvas;

    public SpaceShieldManger(CanvasWindow canvas){
        this.canvas = canvas;
    }

    public static void generateSpaceShields(CanvasWindow canvas) {
        for (int i = 1; i <= 3; i++) {
            SpaceShield spaceShield = new SpaceShield();
            shields.add(spaceShield);
            spaceShield.updatePosition(i * 0.3 * SpaceInvaderz.getCanvasWidth() - 200, SpaceInvaderz.getCanvasHeight() * 0.6);
            spaceShield.addToCanvas(canvas);
            System.out.println("Shiled number " + i);
            // shieldGroup.add(spaceShield);
        }
    }

}
