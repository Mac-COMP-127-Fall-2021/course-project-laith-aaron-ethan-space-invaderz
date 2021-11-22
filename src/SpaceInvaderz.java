import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class SpaceInvaderz {
    
    private static final int CANVAS_WIDTH = 900;
    private static final int CANVAS_HEIGHT = 600;
    private static CanvasWindow canvas;

    private static Image background;


    public SpaceInvaderz(){
        canvas = new CanvasWindow("Space Invaderz!!!", CANVAS_WIDTH, CANVAS_HEIGHT);
        setCanvasBackground();
        SpaceShip spaceShip = new SpaceShip(canvas);
        AlienWall AlienWall = new AlienWall(canvas);

        // make a list of bullets
        // add new bullet on clock
        // animate entire list


        canvas.onMouseMove(event -> spaceShip.updateX(event.getPosition().getX()));
        canvas.onClick(event -> BulletManger.addShot(canvas));
        canvas.animate(() -> BulletManger.shootBullets());



        
    }

    private void setCanvasBackground() {
        background = new Image(0, 0, "background2.png");
        canvas.add(background);
        // background.setScale(0.1);
    }

    public static int getCanvasWidth() {
        return CANVAS_WIDTH;
    }

    public static int getCanvasHeight() {
        return CANVAS_HEIGHT;
    }

    public static CanvasWindow getCanvas() {
        return canvas;
    }
    public static void main(String[] args) {
        new SpaceInvaderz();
        
    }
}
