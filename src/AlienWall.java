import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.*;

public class AlienWall {
    private GraphicsGroup alienGroup;
    private List<Alien> aliens = new ArrayList<Alien>();
    private static CanvasWindow canvas;


    public AlienWall(CanvasWindow canvas) {
        this.canvas = canvas;
        alienGroup = new GraphicsGroup();
        generateAlienWall();
        System.out.print(alienGroup);
        // canvas.add(aliens);
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








    // private void createalienWall(CanvasWindow canvas) {
    // double margin = canvas.getWidth() * 0.05;
    // double spacing = canvas.getWidth() * 0.01;
    // double y = canvas.getWidth() * 0.05;
    // double x = margin;
    // double length = 0;
    // for (int i = 0; i < 48; i++) {
    // Alien alienNew = new Alien();
    // length = length + alienNew.getImageWidth() + spacing;
    // if (length < canvas.getWidth() - 4 * margin) {
    // x = x + alienNew.getImageWidth() + spacing;
    // } else {
    // x = margin;
    // length = 0;
    // y = y + spacing + alienNew.getImageHeight();
    // }
    // // alienGroup.add(alienNew);
    // // aliens.add(alienNew);
    // canvas.add(alienNew.getAlienImage());
    // }
    // }

}

