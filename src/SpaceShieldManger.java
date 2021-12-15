
import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.*;

public class SpaceShieldManger  {
    // private GraphicsGroup shieldGroup;
    private static List<SpaceShield> shields = new ArrayList<SpaceShield>();
    private CanvasWindow canvas;

    public SpaceShieldManger(CanvasWindow canvas){
        this.canvas = canvas;
        generateSpaceShields(canvas);
    }

    public static void generateSpaceShields(CanvasWindow canvas) {
        for (int i = 1; i <= 3; i++) {
            SpaceShield spaceShield = new SpaceShield();
            shields.add(spaceShield);
            spaceShield.setPosition(i * 0.3 * SpaceInvaderz.getCanvasWidth() - 200, SpaceInvaderz.getCanvasHeight() * 0.6);
            canvas.add(spaceShield);
        }
    }

    public List<SpaceShield> getShields() {
        return shields;
    }


}
