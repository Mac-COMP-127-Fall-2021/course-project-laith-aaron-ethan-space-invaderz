import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class SpaceInvaderzTest {
    // ------ Setup ------

    CanvasWindow canvas;

    @Test
    public void testShieldDamageLogic() {
        SpaceShield spaceShield = new SpaceShield();
        spaceShield.getDamged();
        int newCondition = 2;
        assertEquals(newCondition, spaceShield.getHealth());
    }

    @Test
    public void testAlienLogic() {
        canvas = new CanvasWindow("Canvas", 500, 500);
        InteractionManager interactionManager = new InteractionManager();
        SpaceShip spaceShip = new SpaceShip(canvas);
        Bullet bullet = new Bullet(canvas, spaceShip);
        AlienWall alienWall = new AlienWall(canvas);
        Boolean value = interactionManager.alienIntersection(bullet, alienWall, canvas);
        assertFalse(value);
    }

}



