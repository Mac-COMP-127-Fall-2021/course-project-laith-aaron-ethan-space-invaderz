import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class InteractionManager {
    public void alienIntersection(Bullet bullet, Alien alien, CanvasWindow canvas) {
        
        Ellipse Bulletpoint = new Point(Bullet.getCenterX(), Bullet.getCenterY() + Ball.BALL_RADIUS + 1);

        
        if (canvas.getElementAt(bullet) == alien) {
            
        }
    }
}

