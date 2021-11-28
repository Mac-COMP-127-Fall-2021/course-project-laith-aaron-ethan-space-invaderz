import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;

public class AlienWall extends GraphicsGroup {
    
    private List<Alien> aliens = new ArrayList<Alien>();
    private static CanvasWindow canvas;


    public AlienWall(CanvasWindow canvas) {
        super();
        this.canvas = canvas;
        generateAlienWall();
        System.out.print(this);
        canvas.add(this);
    }

    public void generateAlienWall() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                createAlienRow(i, j);
            }
        }
    }

    private void createAlienRow(int i, int j) {
        Alien alien = new Alien();
        aliens.add(alien);
        alien.updatePosition(((alien.getImageWidth() * 0.15) * j) - 200, ((alien.getImageHeight() * 0.15) * i) - 50);
        alien.addToCanvas(canvas);
    }


}

