import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class SpaceInvaderz {

    private static final int CANVAS_WIDTH = 900;
    private static final int CANVAS_HEIGHT = 600;
    private static CanvasWindow canvas = new CanvasWindow("Space Invaderz!!!", CANVAS_WIDTH, CANVAS_HEIGHT);;
    private static AlienWall alienWall;
    private InteractionManager interactionManager;

    private static Image background;

    public SpaceInvaderz(){
        // this.canvas = new CanvasWindow("Space Invaderz!!!", CANVAS_WIDTH, CANVAS_HEIGHT);
        setCanvasBackground();
        SpaceShip spaceShip = new SpaceShip(canvas);
        SpaceShieldManger.generateSpaceShields(canvas);

        alienWall = new AlienWall(canvas);
        interactionManager = new InteractionManager();
        HealthMeter healthMeter = new HealthMeter(CANVAS_WIDTH * 0.75, CANVAS_HEIGHT * 0.05, canvas);
        
        
    
        
        

        canvas.onMouseMove(event -> spaceShip.updateX(event.getPosition().getX()));
        canvas.onClick(event -> BulletManger.addShot(canvas, alienWall));
        canvas.animate(() -> BulletManger.shootBullets(alienWall, interactionManager, canvas)); // this is causing the error, also caused in Bullet Manager

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
