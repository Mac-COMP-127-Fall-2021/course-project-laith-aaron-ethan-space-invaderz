import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

class UnitTests {
    // ------ Setup ------

    CanvasWindow canvas;

    @Test
    public void testShield() {
        SpaceShield spaceShield = new SpaceShield();
        spaceShield.damage();
        int newCondition = 2;
        assertEquals(newCondition, spaceShield.getCondition());
    }

    @Test
    public void testAlienLogic() {
        InteractionManager interactionManager = new InteractionManager();
        SpaceShip spaceShip = new SpaceShip(canvas);
        Bullet bullet = new Bullet(canvas, spaceShip);
        Point bulletTop = new Point(bullet.getX(), bullet.getY() - (bullet.getRadius()+ 1));
        AlienWall alienWall = new AlienWall(canvas);
        Boolean value = interactionManager.alienIntersection(bullet, alienWall, canvas);
        assertTrue(value);
    }

}



